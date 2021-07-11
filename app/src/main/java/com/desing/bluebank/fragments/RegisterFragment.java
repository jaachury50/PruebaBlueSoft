package com.desing.bluebank.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.desing.bluebank.Interfaces.InterfaceCreateAccount;
import com.desing.bluebank.Interfaces.InterfacePresenter;
import com.desing.bluebank.Presenter;
import com.desing.bluebank.R;
import com.desing.bluebank.models.ModelCreateAccount;

import java.util.HashMap;
import java.util.Map;


public class RegisterFragment extends Fragment implements InterfaceCreateAccount {


    View mView;
    EditText nombres,apellidos,cuenta,dinero,cedula;
    Button registrar,numero_cuenta;
    InterfacePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.fragment_register, container, false);
        nombres=mView.findViewById(R.id.NombresEdt);
        apellidos=mView.findViewById(R.id.ApellidosEdt);
        cuenta=mView.findViewById(R.id.CuentaEdt);
        dinero=mView.findViewById(R.id.DineroEdt);
        cedula=mView.findViewById(R.id.CedulaEdt);
        numero_cuenta=mView.findViewById(R.id.CrearNumero);
        registrar=mView.findViewById(R.id.RegistrarBtn);
        presenter=new Presenter(this);



        numero_cuenta.setOnClickListener(view -> {
            int aleatorio;
            aleatorio = (int) (Math.random() * (10000000 - 1000000) + 1000000);
            String resultado = String.valueOf(aleatorio);
            cuenta.setText(resultado);
        });

        registrar.setOnClickListener(v -> {

            if (nombres.getText().toString().isEmpty() || apellidos.getText().toString().isEmpty() || cuenta.getText().toString().isEmpty()
                    || dinero.getText().toString().isEmpty() || cedula.getText().toString().isEmpty()){
               Toast.makeText(getContext(), "COMPLETE EL FORMULARIO", Toast.LENGTH_SHORT).show();
            } else {
                ModelCreateAccount modelCreateAccount=new ModelCreateAccount();
                modelCreateAccount.setCedula(cedula.getText().toString());
                modelCreateAccount.setNombres(nombres.getText().toString());
                modelCreateAccount.setApellidos(apellidos.getText().toString());
                modelCreateAccount.setValor_Cuenta(dinero.getText().toString());
                modelCreateAccount.setNumero_Cuenta(cuenta.getText().toString());
                presenter.Register(modelCreateAccount,getContext());
            }

        });

        return mView;
    }
}