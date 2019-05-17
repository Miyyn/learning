package com.observer.demo;

import com.observer.demo.service.Impl.CurrentConditionsDisplay;
import com.observer.demo.service.Impl.ForecastDisplay;
import com.observer.demo.service.Impl.StatisticsDisplay;
import com.observer.demo.service.Impl.WeatherDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        WeatherDate weatherDate = new WeatherDate();

        CurrentConditionsDisplay currentConditionsDisplay =
                new CurrentConditionsDisplay(weatherDate);
        StatisticsDisplay statisticsDisplay =
                new StatisticsDisplay(weatherDate);
        ForecastDisplay forecastDisplay =
                new ForecastDisplay(weatherDate);
        weatherDate.setMeasurements(80,75,30.4f);
        weatherDate.setMeasurements(78,91,28.5f);
        weatherDate.setMeasurements(76,56,29.4f);

    }

}
