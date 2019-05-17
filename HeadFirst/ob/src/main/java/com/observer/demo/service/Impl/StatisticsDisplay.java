package com.observer.demo.service.Impl;

import com.observer.demo.service.DisplayElement;
import com.observer.demo.service.Observer;
import com.observer.demo.service.Subject;

import java.util.ArrayList;
import java.util.List;


public class StatisticsDisplay implements Observer, DisplayElement {

    private List<Float> list = new ArrayList<>();
    private Subject weatherDate;

    public StatisticsDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        this.weatherDate.registerOberserver(this);
    }

    @Override
    public void display() {
        float min = Float.MAX_VALUE,max = Float.MIN_VALUE,sum=0,ave;
        float a;
        for(int i=0;i<list.size();i++){
            a = list.get(i);
            sum += a;
            if(max <= a){
                max =a;
            }
            if(min >= a){
                min = a;
            }
        }
        ave = sum/list.size();
        System.out.println("Ave/Max/Min  温度 "+ave+"/"+max+"/"+min);
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        list.add(temp);
        display();
    }
}
