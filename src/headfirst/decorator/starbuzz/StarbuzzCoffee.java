package headfirst.decorator.starbuzz;

public class StarbuzzCoffee {

	/*
	* Decorated-object and Decorator-object should be of the same type because:
	* 1. Need to be able to create objects of DECORATORS and assign them to variable of DECORATED's-type.
	* 2. Having type of DECORATOR-object same as type of DECORATED-object, it's possible to use polymorphism by calling
	*    variative behavior using same method name/signature (.cost() method changes as decorated object is wrapped into
	*    more and more decorator-objects).
	* */
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() 
				+ " $" + beverage.cost());
 
		Beverage beverage2 = new DarkRoast();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		beverage2 = new Whip(beverage2);
		beverage2 = new Zephir(beverage2);
		System.out.println(beverage2.getDescription() 
				+ " $" + beverage2.cost());
 
		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		beverage3 = new Mocha(beverage3);
		beverage3 = new Whip(beverage3);
		beverage3 = new Zephir(beverage3);
		if(beverage3 instanceof Beverage)
		System.out.println(beverage3.getDescription()
				+ " $" + beverage3.cost());
	}
}
