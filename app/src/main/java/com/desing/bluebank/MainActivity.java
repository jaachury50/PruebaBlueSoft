package com.desing.bluebank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.desing.bluebank.fragments.MenuPrincipalFragment;
import com.desing.bluebank.fragments.RegisterFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView registrar;
    EditText cedula,contraseña;
    Button ingresar;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //ingresar.setOnClickListener(view -> {IniciarSesion("https://pruebaingresobluesoft.000webhostapp.com/Login.php"); });

        //registrar.setOnClickListener(view -> openFragment(new RegisterFragment()));


    }

    public void openFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void IniciarSesion(String URL){
        final ProgressDialog loading = ProgressDialog.show(this,"Iniciando Sesión...","Espere por favor...",false,false);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equalsIgnoreCase("Exito")){
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(),"Ingreso Exitoso",Toast.LENGTH_SHORT).show();
                    openFragment(new MenuPrincipalFragment());
                }else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(),"Error Al Iniciar Sesión",Toast.LENGTH_SHORT).show();
                }
                Log.d("response_login",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(),"COMPRUEBE SU CONEXIÓN A INTERNET",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("Cedula",cedula.getText().toString());
                parametros.put("Contraseña",contraseña.getText().toString());
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}