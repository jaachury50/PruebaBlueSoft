package com.desing.bluebank.models;

import java.io.Serializable;

public class ModelCreateAccount implements Serializable {
    String  Cedula;
    String Nombres;
    String Apellidos;
    String Valor_Cuenta;
    String Numero_Cuenta;

    public ModelCreateAccount() {
    }

    public ModelCreateAccount(String cedula, String nombres, String apellidos, String valor_Cuenta, String numero_Cuenta) {
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
        Valor_Cuenta = valor_Cuenta;
        Numero_Cuenta = numero_Cuenta;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getValor_Cuenta() {
        return Valor_Cuenta;
    }

    public void setValor_Cuenta(String valor_Cuenta) {
        Valor_Cuenta = valor_Cuenta;
    }

    public String getNumero_Cuenta() {
        return Numero_Cuenta;
    }

    public void setNumero_Cuenta(String numero_Cuenta) {
        Numero_Cuenta = numero_Cuenta;
    }
}
