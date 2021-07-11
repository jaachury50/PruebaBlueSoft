package com.desing.bluebank.Interfaces;

import android.content.Context;

import com.desing.bluebank.models.ModelCreateAccount;

public interface InterfacePresenter {
    void Register(ModelCreateAccount modelCreateAccount, Context context);
    void Consigned(String Numero_Cuenta,String Valor,Context context);
    void Retired(String Numero_Cuenta,String Valor,Context context);
    void Consult(String Numero_Cuenta,Context context);
    void ResultInterctor(boolean result,int valor);
}
