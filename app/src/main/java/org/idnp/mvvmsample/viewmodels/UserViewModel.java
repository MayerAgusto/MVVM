package org.idnp.mvvmsample.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import org.idnp.mvvmsample.Register;
import org.idnp.mvvmsample.Visit;
import org.idnp.mvvmsample.model.User;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {
    private Context context;
    private Bundle bundle;
    private ArrayList<User> pacients = new ArrayList<User>();
    private String message;

    public UserViewModel(Context context, Bundle bundle){
        this.context = context;
        this.bundle = bundle;

        if (bundle != null){
            int code = bundle.getInt("code");
            if(code == 1){
                String name = bundle.getString("name");
                String dni = bundle.getString("dni");
                String address = bundle.getString("address");
                createUser(name,dni,address);
            }
            if(code == 2){
                String userDni = bundle.getString("userDni");
                String weight = bundle.getString("weight");
                String temperature = bundle.getString("temperature");
                String press = bundle.getString("press");
                String saturation = bundle.getString("saturation");

                int indexPerson = findIndexUser(userDni);
                saveUserData(indexPerson,weight,temperature,press,saturation );
            }
        }else{
            setMessage("No hay pacientes inscritos");
        }
    }
    @Bindable
    public String getMessage(){ return message; }

    public void setMessage(String message){
        this.message = message;
        notifyPropertyChanged(BR.message);
    }
    public void createUser(String name, String dni, String address){
        User user =  new User();
        user.setName(name);
        user.setDni(dni);
        user.setAddress(address);
        pacients.add(user);
        showPacients();
    }
    public void showPacients(){
        String sendmessage = "";
        for(int i= 0; i< pacients.size(); i++){
            sendmessage= sendmessage + pacients.get(i).toString();
        }
        setMessage(sendmessage);
    }
    public int findIndexUser(String dni){
        int i=0;
        for(int j =0; j < pacients.size(); j++){
            if(pacients.get(j).getDni() == dni){
               return j;
            }
        }
        return i;
    }
    public void saveUserData(int i, String weight, String temperature, String press, String saturation){
        double w = Double.parseDouble(weight);
        double t = Double.parseDouble(temperature);
        double p = Double.parseDouble(press);
        double s = Double.parseDouble(saturation);

        pacients.get(i).setUserInfo(w,t,p,s);
        showPacients();
    }
    public void goRegister(){
        Intent intent = new Intent(context, Register.class);
        context.startActivity(intent);
    }
    public void goView(){
        Intent intent = new Intent(context, Visit.class);
        context.startActivity(intent);
    }

}