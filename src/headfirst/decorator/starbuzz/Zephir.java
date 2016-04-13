package headfirst.decorator.starbuzz;

import headfirst.composite.menuiterator.CompositeIterator;

import java.util.Iterator;

/**
 * Created by ispitkovskyi on 3/28/2015.
 */
public class Zephir extends CondimentDecorator {
    Beverage beverage;

    public Zephir (Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        if(beverage == null){
            System.exit(1);
        }
        return beverage.getDescription() + ", Zephir";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.55;
    }

    @Override
    public String getSize() {
        //See example of implementation in the "Wheep" class
        return null;
    }
}
