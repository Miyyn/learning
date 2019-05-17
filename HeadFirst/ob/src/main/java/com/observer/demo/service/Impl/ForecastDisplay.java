package com.observer.demo.service.Impl;

import com.observer.demo.service.DisplayElement;
import com.observer.demo.service.Observer;
import com.observer.demo.service.Subject;

public class ForecastDisplay implements Observer, DisplayElement {


    private String str;
    private Subject weatherDate;

    public ForecastDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        this.weatherDate.registerOberserver(this);
    }

    @Override
    public void display() {
        System.out.println("预测："+str);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
            if(humidity >= 90){
                str = "要下暴雨";
            }else if(humidity >= 70){
                str = "要下雷阵雨";
            }else{
                str = "阳光明媚";
            }
            display();
    }
}
