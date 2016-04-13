package headfirst.decorator.starbuzz;
 
public class Whip extends CondimentDecorator {
	Beverage beverage;
 
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		double cost =  beverage.cost();
		String size = getSize();
		if(size == Beverage.LARGE) {
			cost += .20;
		}else if(size == Beverage.MIDDLE){
			cost += 0.15;
		}else if (size == Beverage.SMALL){
			cost += 0.10;
		}
		return cost;
	}

	@Override
	public String getSize() {
		return beverage.getSize();
	}
}
