package com.desing.bluebank.fragments;

import android.app.ProgressDialog;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.desing.bluebank.Interfaces.InterfaceConsult;
import com.desing.bluebank.Interfaces.InterfacePresenter;
import com.desing.bluebank.Presenter;
import com.desing.bluebank.R;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class ConsultarFragment extends Fragment implements InterfaceConsult {

    View mView;
    EditText Numero_Cuenta;
    LinearLayout linearLayout;
    Button Consultar;
    TextView saldo;
    InterfacePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.fragment_consultar, container, false);
        Numero_Cuenta=mView.findViewById(R.id.CuentaConsultarEd);
        Consultar=mView.findViewById(R.id.ConsultarBtn);
        linearLayout=mView.findViewById(R.id.LinearSaldo);
        saldo=mView.findViewById(R.id.SaldoActualTv);
        presenter=new Presenter(this);

        Consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.Consult(Numero_Cuenta.getText().toString(),getContext());

            }
        });

        return mView;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void result(boolean result, int valor) {
        if (result && valor != 0){
            DecimalFormat formatea = new DecimalFormat("###,###.##");
            linearLayout.setVisibility(View.VISIBLE);
            saldo.setText(formatea.format(valor));
        }else {
            linearLayout.setVisibility(View.GONE);
            saldo.setText(0);
        }
    }
}