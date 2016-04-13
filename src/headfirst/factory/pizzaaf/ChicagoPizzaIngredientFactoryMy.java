package headfirst.factory.pizzaaf;
public class ChicagoPizzaIngredientFactoryMy implements PizzaIngredientFactory {

    public Dough createDough() {
        return new ThickCrustDough();
    }
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }
    public Veggies[] createVeggies() {
        Veggies veggies [] = {new Spinach(), new BlackOlives(), new Eggplant()};
        return veggies;
    }
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }
    public Clams createClam() {
        return new FrozenClams();
    }
}
