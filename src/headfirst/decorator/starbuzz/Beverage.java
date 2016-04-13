package headfirst.decorator.starbuzz;

public abstract class Beverage {
	String size;
	String description = "Unknown Beverage";

	public static final String LARGE = "Large";
	public static final String MIDDLE = "Middle";
	public static final String SMALL = "Small";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();

	public void setSize(String size){
		this.size = size;
	}

	public abstract String getSize();
}
