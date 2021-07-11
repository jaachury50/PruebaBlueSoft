package com.desing.bluebank;

import android.app.ProgressDialog;
import android.content.Context;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.desing.bluebank.Interfaces.InterfaceInteractor;
import com.desing.bluebank.Volley.SingletonVolley;
import com.desing.bluebank.models.ModelCreateAccount;

import java.util.HashMap;
import java.util.Map;

public class Interactor implements InterfaceInteractor {
    private Presenter presenter;

    public Interactor(Presenter presenter){
        this.presenter=presenter;
    }

    @Override
    public void CreateUser(ModelCreateAccount modelCreateAccount, Context context) {
        final ProgressDialog loading = ProgressDialog.show(context,"Subiendo...","Espere por favor...",false,false);
        String URL="https://pruebaingresobluesoft.000webhostapp.com/registrar.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equalsIgnoreCase("SUBIDO EXITOSAMENTE")){
                    loading.dismiss();
                    Toast.makeText(context,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                }else {
                    loading.dismiss();
                    Toast.makeText(context,"Error En El Registro",Toast.LENGTH_SHORT).show();
                }
                Log.d("responsetemp",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(context,"COMPRUEBE SU FORMULARIO O CONEXIÓN A INTERNET",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("Cedula",modelCreateAccount.getCedula());
                parametros.put("Nombres",modelCreateAccount.getNombres());
                parametros.put("Apellidos",modelCreateAccount.getApellidos());
                parametros.put("Valor_Cuenta",modelCreateAccount.getValor_Cuenta());
                parametros.put("Numero_Cuenta",modelCreateAccount.getNumero_Cuenta());
                Log.d("response", String.valueOf(parametros));
                return parametros;
            }
        };
        SingletonVolley.getInstance(context).addToRequestQueue(stringRequest);
    }

    @Override
    public void Consigned(String Numero_Cuenta, String Valor, Context context) {
        String URL="https://pruebaingresobluesoft.000webhostapp.com/Consignacion.php";
        final ProgressDialog loading = ProgressDialog.show(context,"Realizando Consignación...","Espere por favor...",false,false);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responseconsig",response);
                if (response.trim().equalsIgnoreCase("Exito")) {
                    loading.dismiss();
                    Toast.makeText(context, "Consignación Exitosa", Toast.LENGTH_SHORT).show();
                }else {
                    loading.dismiss();
                    Toast.makeText(context, "Error En La Consignación", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(context,"ERROR AL REALIZAR CONSIGNACIÓN",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("Numero_Cuenta",Numero_Cuenta);
                parametros.put("Valor",Valor);
                Log.d("parametrosconsig", String.valueOf(parametros));
                return parametros;
            }
        };
        SingletonVolley.getInstance(context).addToRequestQueue(stringRequest);
    }

    @Override
    public void Retired(String Numero_Cuenta, String Valor, Context context) {
        String URL="https://pruebaingresobluesoft.000webhostapp.com/Retiro.php";
        final ProgressDialog loading = ProgressDialog.show(context,"Realizando Retiro...","Espere por favor...",false,false);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("responseretiro",response);
                if (response.trim().equalsIgnoreCase("Exito")) {
                    loading.dismiss();
                    Toast.makeText(context, "Retiro Exitoso", Toast.LENGTH_SHORT).show();
                }else if (response.trim().equalsIgnoreCase("ERROR 1")){
                    loading.dismiss();
                    Toast.makeText(context, "Saldo Insuficiente", Toast.LENGTH_SHORT).show();
                }else {
                    loading.dismiss();
                    Toast.makeText(context, "ERROR AL REALIZAR RETIRO", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(context,"VERIFIQUE SU CONEXIÓN A INTERNET",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("Numero_Cuenta",Numero_Cuenta);
                parametros.put("Valor",Valor);
                Log.d("parametrosretiro", String.valueOf(parametros));
                return parametros;
            }
        };
        SingletonVolley.getInstance(context).addToRequestQueue(stringRequest);
    }

    @Override
    public void Consult(String Numero_Cuenta, Context context) {
        String URL="https://pruebaingresobluesoft.000webhostapp.com/Consultar.php";
        final ProgressDialog loading = ProgressDialog.show(context,"Realizando Consignación...","Espere por favor...",false,false);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(String response) {
                Log.d("responseconsulta",response);
                boolean resultado = response.contains("Exito");
                if (resultado) {
                    loading.dismiss();
                    String valor=response.replaceAll("[E-x-i-t-o]","");
                    int valorfinal= Integer.parseInt(valor);
                    presenter.ResultInterctor(resultado,valorfinal);
                    Toast.makeText(context, "Consulta Exitosa", Toast.LENGTH_SHORT).show();
                }else if (response.trim().equalsIgnoreCase("ERROR 1")){
                    presenter.ResultInterctor(false,0);
                    loading.dismiss();

                    Toast.makeText(context, "No Se Encontro El Número De Cuenta", Toast.LENGTH_SHORT).show();
                }else{
                    loading.dismiss();
                    Toast.makeText(context, "ERROR EN LA CONSULTA", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loading.dismiss();
                Toast.makeText(context,"VERIFIQUE SU CONEXIÓN A INTERNET",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("Numero_Cuenta",Numero_Cuenta);
                Log.d("parametrosconsulta", String.valueOf(parametros));
                return parametros;
            }
        };
        SingletonVolley.getInstance(context).addToRequestQueue(stringRequest);
    }
}
