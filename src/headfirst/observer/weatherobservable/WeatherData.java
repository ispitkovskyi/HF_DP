package headfirst.observer.weatherobservable;
	
import java.util.Observable;
import java.util.Observer;
	
public class WeatherData extends Observable {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() { }
	
	public void measurementsChanged() {
		setChanged(); //IgorS: method of parent Observable class. Sets flag, that something was changed. This flag is verified, when you call the "notifyObservers()" method
		notifyObservers(); //IgorS: this method, if "changed=true", goes through list of observers registered, and calls "update" method for each of them (the "update" method is implementation of "Observer" interface)
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged(); //This method contains calls of standard methods from inherited "Observable" parent class, which will do all the "notification" work for registered observers
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}
}
