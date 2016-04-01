package patterns.observer;

/**
 * Created by User on 29.03.2016.
 */
public class WeatherStationMain {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        CurrentDisplay currentDisplay = new CurrentDisplay();
        StatisticDisplay statisticDisplay = new StatisticDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        station.addObserver(currentDisplay);
        station.addObserver(statisticDisplay);
        station.addObserver(forecastDisplay);

        station.setTemperature(20);
        station.setHumidity(50);
        station.setPressure(750);
        station.stateChanged();

        statisticDisplay.display();
        currentDisplay.display();
        forecastDisplay.display();

        /*station.removeObserver(forecastDisplay);*/

        station.setTemperature(25);
        station.setHumidity(54);
        station.setPressure(730);
        station.stateChanged();

        statisticDisplay.display();
        currentDisplay.display();
        forecastDisplay.display();
    }

}
