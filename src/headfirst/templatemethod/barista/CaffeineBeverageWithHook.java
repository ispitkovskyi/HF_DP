package headfirst.templatemethod.barista;

public abstract class CaffeineBeverageWithHook {
 
	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}
 
	abstract void brew();
 
	abstract void addCondiments();
 
	void boilWater() {
		System.out.println("Boiling water");
	}
 
	void pourInCup() {
		System.out.println("Pouring into cup");
	}

	//This is hook-method, which can be overriden in child-classes
	boolean customerWantsCondiments() {
		return true;
	}
}
