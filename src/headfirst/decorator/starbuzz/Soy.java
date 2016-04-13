package headfirst.decorator.starbuzz;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}

	@Override
	public String getSize() {
		//See example of implementation in the "Wheep" class
		return null;
	}
}
