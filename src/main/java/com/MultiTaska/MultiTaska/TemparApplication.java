package com.MultiTaska.MultiTaska;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;


public class TemparApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemparApplication.class, args);
    }


}

class WeatherResponse {
    private CurrentInfo current;

    public CurrentInfo getCurrent() {
        return current;
    }

    public void setCurrent(CurrentInfo current) {
        this.current = current;
    }
}

class CurrentInfo {
    @JsonProperty("temp_c")
    private double  temp_c;
    private int humidity;
    private int cloud;
    @JsonProperty("pressure_mb")
    private double  pressure_mb;

    public double  getTempC() {
        return temp_c;
    }



    public int getHumidity() {
        return humidity;
    }
    public int getCloud(){
        return cloud;
    }

    public double  getPressureMb() {
        return pressure_mb;
    }


}

class WeatherInfo {
    private double  temp;
    private int humidity;
    private int cloud;
    private double  pressure;

    public WeatherInfo(double  temp, int humidity ,int cloud,double  pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.cloud = cloud;
        this.pressure = pressure;
    }

    public double  getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }
    public int getCloud(){
        return cloud;
    }

    public double  getPressure() {
        return pressure;
    }

}