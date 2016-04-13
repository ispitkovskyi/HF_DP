package headfirst.decorator.starbuzz;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		size = Beverage.LARGE;
		description = "House Blend Coffee";
	}
 
	public double cost() {
		return .89;
	}

	@Override
	public String getSize() {
		return this.size;
	}
}

