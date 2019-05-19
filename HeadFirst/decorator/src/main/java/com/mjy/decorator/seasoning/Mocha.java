package com.mjy.decorator.seasoning;

import com.mjy.decorator.Beverage;
import com.mjy.decorator.CondimentDecorator;

/**
 * 摩卡
 */
public class Mocha extends CondimentDecorator {

    public Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
