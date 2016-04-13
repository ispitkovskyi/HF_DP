package headfirst.observer.weatherobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by igors on 22.03.15.
 */
public class ForecastDisplayMy implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplayMy(Observable observable){
        observable.addObserver(this); //No need to have WeatherData type here, because we call method of Observable super-class
    }

    @Override
    public void update(Observable observable, Object arg) {
        if(observable instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)observable;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.print("Forecast MY CUSTOM IMPLEMENTATION OF TASK AT PAGE 103: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
