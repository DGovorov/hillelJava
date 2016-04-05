package patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 29.03.2016.
 */
public class StatisticDisplay implements Observer{
    private List<Integer> temperatures = new ArrayList<Integer>();
    private List<Integer> humidities = new ArrayList<Integer>();
    private List<Integer> pressures = new ArrayList<Integer>();

    @Override
    public void update (WeatherStation station){
        temperatures.add(station.getTemperature());
        humidities.add(station.getHumidity());
        pressures.add(station.getPressure());
    }

    public void display(){
        System.out.println("STATISTIC: temperature: " + temperatures +
                ", humidity: " + humidities +
                ", pressure: " + pressures);
    }



}
