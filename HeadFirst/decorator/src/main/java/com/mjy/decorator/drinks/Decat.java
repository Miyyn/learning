package com.mjy.decorator.drinks;

import com.mjy.decorator.Beverage;

public class Decat extends Beverage {


    public Decat() {
        description = "Decat(低咖啡因)";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
