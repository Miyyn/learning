package com.mjy.decorator.drinks;


import com.mjy.decorator.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend(综合)";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
