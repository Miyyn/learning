package com.observer.demo.service.Impl;

import com.observer.demo.service.DisplayElement;
import com.observer.demo.service.Observer;
import com.observer.demo.service.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherDate;

    public CurrentConditionsDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        this.weatherDate.registerOberserver(this);
    }

    @Override
    public void display() {
        System.out.println("目前状况：温度/"+temperature+" 湿度/"+humidity);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
            this.temperature = temp;
            this.humidity = humidity;
            display();
    }
}
