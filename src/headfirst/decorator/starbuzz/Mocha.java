package headfirst.decorator.starbuzz;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
 
	public Mocha(Beverage beverage) {
		this.beverage = beverage; //Here is the COMPOSITION used instead of INHERITANCE between decorator-object and decorated-object
	}

	//Implementation of abstract method from abstract super class CondimentDecorator
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	//Implementation of abstract method from abstract super class Beverage
	public double cost() {
		return .20 + beverage.cost();
	}

	@Override
	public String getSize() {
		//See example of implementation in the "Wheep" class
		return null;
	}

}
