package com.mjy.decorator.drinks;

import com.mjy.decorator.Beverage;

public class DrakRoast extends Beverage {


    public DrakRoast() {
        description = "DrakRoast(深焙)";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
