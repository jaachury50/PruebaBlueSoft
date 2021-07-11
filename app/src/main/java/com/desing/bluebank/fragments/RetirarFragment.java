package com.desing.bluebank.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.desing.bluebank.Interfaces.InterfacePresenter;
import com.desing.bluebank.Interfaces.InterfaceRetired;
import com.desing.bluebank.Presenter;
import com.desing.bluebank.R;

import java.util.HashMap;
import java.util.Map;


public class RetirarFragment extends Fragment implements InterfaceRetired {

    View mView;

    EditText Numero_Cuenta,Valor;
    Button Retirar;
    RequestQueue requestQueue;
    InterfacePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.fragment_retirar, container, false);
        Numero_Cuenta=mView.findViewById(R.id.CuentaRetirarEd);
        Valor=mView.findViewById(R.id.CantidadRetirarEd);
        Retirar=mView.findViewById(R.id.RetirarDineroBtn);
        presenter=new Presenter(this);

        Retirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.Retired(Numero_Cuenta.getText().toString(),Valor.getText().toString(),getContext());
            }
        });
        return mView;
    }


}