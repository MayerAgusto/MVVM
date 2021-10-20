package org.idnp.mvvmsample.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.databinding.Bindable;
import androidx.databinding.BaseObservable;
import androidx.databinding.library.baseAdapters.BR;

import org.idnp.mvvmsample.MainActivity;
import org.idnp.mvvmsample.Register;

public class RegisterViewModel extends BaseObservable {
    private Context context;
    @Bindable
    private String name;
    @Bindable
    private String address;
    @Bindable
    private String dni;

    public String getName(){ return name; }
    public void setName(String name){
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    public RegisterViewModel(Context context){
        this.context = context;
    }

    public String getDni(){return  dni;}
    public void setDni(String dni){
        this.dni = dni;
        notifyPropertyChanged(BR.dni);
    }

    public String getAddress(){ return address; }
    public void setAddress(String address){
        this.address = address;
        notifyPropertyChanged(BR.address);
    }
    public void go(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("code",1);
        intent.putExtra("name", name);
        intent.putExtra("dni", dni);
        intent.putExtra("address", address);
        context.startActivity(intent);

    }

}
