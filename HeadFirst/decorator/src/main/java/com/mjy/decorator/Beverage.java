package com.mjy.decorator;

/**
 * 饮料父类
 */
public abstract class Beverage {

    public String description = "UnKnown Beverage";

    public String getDescription() {
        return description;
    }
    public abstract double cost();
}
