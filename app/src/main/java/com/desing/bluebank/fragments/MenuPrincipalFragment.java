package com.desing.bluebank.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.desing.bluebank.R;


public class MenuPrincipalFragment extends Fragment {

    View mView;
    Button crear,consignar,retirar,consultar;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.fragment_menu_principal, container, false);
        crear=mView.findViewById(R.id.CrearCuentaBtn);
        consignar=mView.findViewById(R.id.ConsigarBtn);
        retirar=mView.findViewById(R.id.RetirarBtn);
        consultar=mView.findViewById(R.id.ConsultarSaldoBtn);

        crear.setOnClickListener(view -> {
            Navigation.findNavController(mView).navigate(R.id.action_menuPrincipalFragment_to_registerFragment);
        });

        consignar.setOnClickListener(view -> {
            Navigation.findNavController(mView).navigate(R.id.action_menuPrincipalFragment_to_consignacionFragment);
        });

        retirar.setOnClickListener(view -> {
            Navigation.findNavController(mView).navigate(R.id.action_menuPrincipalFragment_to_retirarFragment);
        });

        consultar.setOnClickListener(view -> {
            Navigation.findNavController(mView).navigate(R.id.action_menuPrincipalFragment_to_consultarFragment);
        });

        return mView;
    }
}