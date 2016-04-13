package headfirst.decorator.starbuzz;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		size = Beverage.MIDDLE;
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}

	@Override
	public String getSize() {
		return this.size;
	}
}

