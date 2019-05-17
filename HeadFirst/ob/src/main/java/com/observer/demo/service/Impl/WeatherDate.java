package com.observer.demo.service.Impl;

import com.observer.demo.service.Observer;
import com.observer.demo.service.Subject;

import java.util.ArrayList;

public class WeatherDate implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDate() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerOberserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeOberserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyOberservers() {
        for(int i=0;i<observers.size();i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyOberservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
