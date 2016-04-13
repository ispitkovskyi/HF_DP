package headfirst.decorator.starbuzz;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
		size = Beverage.MIDDLE;
	}
 
	public double cost() {
		return 1.05;
	}

	@Override
	public String getSize() {
		return this.size;
	}
}

