package org.aplas.basicappx;

public class Temperature {
    private double celcius;

    public Temperature() {
        this.celcius = 0;
    }

    public double getCelcius() {
        return celcius;
    }

    public void setCelcius(double celcius) {
        this.celcius = celcius;
    }

    public double getFahrenheit(){
        return (celcius*9/5) + 32;
    }

    public void setFahrenheit(double celcius){
        this.celcius  = (celcius-32)/9*5;
    }

    public double getKelvins(){
        return celcius + 273.15;
    }

    public void setKelvins(double celcius){
        this.celcius = celcius - 273.15;
    }

    public double convert(String oriUnit, String convUnit, double value){
        if (oriUnit.equals("°C")){
            setCelcius(value);
        }else if(oriUnit.equals("°F")){
            setFahrenheit(value);
        }else {
            setKelvins(value);
        }
        if (convUnit.equals("°C")){
            return getCelcius();
        }else if(convUnit.equals("°F")){
            return getFahrenheit();
        }else {
            return getKelvins();
        }
    }
}
