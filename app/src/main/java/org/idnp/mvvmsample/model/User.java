package org.idnp.mvvmsample.model;

import java.util.ArrayList;

public class User {
    private String dni;
    private String name;
    private String address;
    private ArrayList<Data> dates;

    public User(){
        dates = new ArrayList<Data>();
    }

    private class Data{
        private double weight;
        private double temperature;
        private double press;
        private double saturation;

        public Data(double weight, double temperature, double press, double saturation){
            this.weight = weight;
            this.temperature = temperature;
            this.press = press;
            this.saturation = saturation;
        }
        public String toString(){
            String message = "[" + "\n";
            message+= "Peso: " +  "\t" + weight + "\n";
            message+= "Temp: " +  "\t" + temperature + "\n";
            message+= "Pres: " +  "\t" + press + "\n";
            message+= "Satu: " +  "\t" + saturation + "\n";
            message+= "]" + "\n";
            return message;
        }
    }
    public void setUserInfo(double weight, double temperature, double press, double saturation){
        Data data = new Data(weight,temperature,press,saturation);
        dates.add(data);
    }
    public void setDni(String dni){this.dni =dni;}
    public void setName(String name){this.name = name;}
    public void setAddress(String address){this.address = address;}

    public String getDni(){return dni;}
    public String getName(){return  name;}
    public String getAddress(){return address;}

    public String toString(){
        String message="Nombre:" + "\t" + name + "\n" ;
        message+="DNI:" + "\t" + dni+ "\n";
        message+="Direccion:" + "\t" + address+ "\n";
        for (int i=0; i < dates.size(); i++){
            message+= dates.get(i).toString();
        }
        return  message;
    }
}
