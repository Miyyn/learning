package com.mjy.decorator;

import com.mjy.decorator.drinks.DrakRoast;
import com.mjy.decorator.drinks.Espresso;
import com.mjy.decorator.drinks.HouseBlend;
import com.mjy.decorator.javaIO.LowerCaseInputStream;
import com.mjy.decorator.seasoning.Mocha;
import com.mjy.decorator.seasoning.Soy;
import com.mjy.decorator.seasoning.Whip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DecoratorApplicationTests {

    /**
     * 装饰着模式：动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。
     */

    @Test
    public void contextLoads() {

        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+" $"+beverage.cost());


        Beverage beverage2 = new DrakRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+" $"+beverage2.cost());


        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()+" $"+beverage3.cost());

    }

    @Test
    public void inputTest() {

        int c;

        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("D:/test/learning/HeadFirst/decorator/text.txt")));

            while((c = in.read() ) > 0 ){
                System.out.print((char)c);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
