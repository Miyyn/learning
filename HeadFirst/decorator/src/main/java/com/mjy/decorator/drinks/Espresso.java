package com.mjy.decorator.drinks;


import com.mjy.decorator.Beverage;

public class Espresso extends Beverage {


    public Espresso() {
        description = "Espresso(浓)";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
