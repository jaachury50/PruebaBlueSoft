package com.desing.bluebank;

import android.content.Context;

import com.desing.bluebank.Interfaces.InterfaceConsigned;
import com.desing.bluebank.Interfaces.InterfaceConsult;
import com.desing.bluebank.Interfaces.InterfaceCreateAccount;
import com.desing.bluebank.Interfaces.InterfaceInteractor;
import com.desing.bluebank.Interfaces.InterfacePresenter;
import com.desing.bluebank.Interfaces.InterfaceRetired;
import com.desing.bluebank.models.ModelCreateAccount;

public class Presenter implements InterfacePresenter {
    private InterfaceCreateAccount ViewRegister;
    private InterfaceConsigned ViewConsigned;
    private InterfaceRetired ViewRetired;
    private InterfaceConsult ViewConsult;
    private InterfaceInteractor interactor;

    public Presenter(InterfaceConsult viewConsult) {
        this.ViewConsult = viewConsult;
        this.interactor=new Interactor(this);
    }

    public Presenter(InterfaceRetired viewRetired) {
        this.ViewRetired = viewRetired;
        this.interactor=new Interactor(this);
    }

    public Presenter(InterfaceConsigned viewConsigned) {
        this.ViewConsigned = viewConsigned;
        this.interactor=new Interactor(this);
    }

    public Presenter(InterfaceCreateAccount viewRegister){
        this.ViewRegister=viewRegister;
        this.interactor=new Interactor(this);
    }

    @Override
    public void Register(ModelCreateAccount modelCreateAccount, Context context) {
        if (interactor!=null){
            interactor.CreateUser(modelCreateAccount,context);
        }
    }

    @Override
    public void Consigned(String Numero_Cuenta, String Valor, Context context) {
        if(interactor!=null){
            interactor.Consigned(Numero_Cuenta,Valor,context);
        }
    }

    @Override
    public void Retired(String Numero_Cuenta, String Valor, Context context) {
        if(interactor!=null){
            interactor.Retired(Numero_Cuenta,Valor,context);
        }
    }

    @Override
    public void Consult(String Numero_Cuenta, Context context) {
        if(interactor!=null){
            interactor.Consult(Numero_Cuenta,context);
        }
    }

    @Override
    public void ResultInterctor(boolean result, int valor) {
        if (ViewConsult!=null){
            ViewConsult.result(result,valor);
        }
    }
}
