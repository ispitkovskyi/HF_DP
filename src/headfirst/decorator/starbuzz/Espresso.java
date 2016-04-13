package headfirst.decorator.starbuzz;

public class Espresso extends Beverage {
	public Espresso() {
		size = Beverage.SMALL;
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}

	@Override
	public String getSize() {
		return this.size;
	}
}

