package com.mjy.decorator.seasoning;

import com.mjy.decorator.Beverage;
import com.mjy.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {

    public Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
