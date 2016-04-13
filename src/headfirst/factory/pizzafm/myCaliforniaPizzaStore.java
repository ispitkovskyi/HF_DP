package headfirst.factory.pizzafm;

/**
 * Created by igors on 4/8/15.
 */
public class myCaliforniaPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheeze")){
            return new myCaliforniaStyleCheezePizza();
        }else if(type.equals("clam")){
            return new myCaliforniaStyleClamPizza();
        }else if(type.equals("pepperoni")){
            return new myCaliforniaStylePepperoniPizza();
        }
        return null;
    }
}
