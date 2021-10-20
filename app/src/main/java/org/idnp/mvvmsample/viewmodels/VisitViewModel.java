package org.idnp.mvvmsample.viewmodels;
import androidx.databinding.BaseObservable;


import androidx.databinding.library.baseAdapters.BR;
import androidx.databinding.Bindable;
import android.content.Context;
import android.content.Intent;

import org.idnp.mvvmsample.MainActivity;

public class VisitViewModel extends BaseObservable {
    private Context context;
    @Bindable
    private String weight;
    @Bindable
    private String temperature;
    @Bindable
    private String press;
    @Bindable
    private String saturation;
    @Bindable
    private String userdni;
    public String getUserdni(){return userdni;}
    public void setUserdni(String userdni){
        this.userdni = userdni;
        notifyPropertyChanged(BR.userdni);
    }

    public String getWeight(){return weight;}
    public void setWeight(String weight){
        this.weight = weight;
        notifyPropertyChanged(BR.weight);
    }

    public String getTemperature(){return temperature;}
    public void setTemperature(String temperature){
        this.temperature = temperature;
        notifyPropertyChanged(BR.temperature);

    }
    public String getPress(){return press;}
    public void setPress(String press){
        this.press = press;
        notifyPropertyChanged(BR.press);
    }

    public String getSaturation(){return saturation;}
    public void setSaturation(String saturation){
        this.saturation = saturation;
        notifyPropertyChanged(BR.saturation);
    }
    public VisitViewModel(Context context){
        this.context = context;
    }

    public void goToMain(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("code",2);
        intent.putExtra("userDni", userdni);
        intent.putExtra("weight", weight);
        intent.putExtra("temperature", temperature);
        intent.putExtra("press", press);
        intent.putExtra("saturation", saturation);
        context.startActivity(intent);
    }

}
