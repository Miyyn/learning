package com.mjy.decorator.seasoning;

import com.mjy.decorator.Beverage;
import com.mjy.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return 0.15 + beverage.cost();
    }
}
