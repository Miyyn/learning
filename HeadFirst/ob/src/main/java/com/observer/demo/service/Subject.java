package com.observer.demo.service;

public interface Subject {

    public void registerOberserver(Observer o);
    public void removeOberserver(Observer o);
    public void notifyOberservers();
}
