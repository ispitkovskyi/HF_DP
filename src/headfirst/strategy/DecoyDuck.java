package headfirst.strategy;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());  //Initializes "flyBehavior" and "quackBehavior" variable in super class Duck using set-methods. Just a different way of initialization.
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
