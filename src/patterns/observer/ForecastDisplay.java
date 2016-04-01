package patterns.observer;

import java.util.Random;

/**
 * Created by User on 29.03.2016.
 */
public class ForecastDisplay implements Observer{
    private int temperature;
    private int humidity;
    private int pressure;
    private Random random = new Random();

    @Override
    public void update(int temperature, int humidity, int pressure) {
        this.temperature = randomize(temperature);
        this.humidity = randomize(humidity);
        this.pressure = randomize(pressure);
    }

    public void display(){
        System.out.println("FORECAST: temperature: " + temperature +
                ", humidity: " + humidity +
                ", pressure: " + pressure);
    }

    private int randomize(int value) {
        double seed = random.nextDouble() / 5 + 0.9;
        return (int) (value * seed);
    }
}
