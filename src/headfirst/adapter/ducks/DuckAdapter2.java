package headfirst.adapter.ducks;

import java.util.Random;

/**
 * Created by igors on 05.11.15.
 */
public class DuckAdapter2 implements Turkey {
    Duck duck;
    Random random;

    public DuckAdapter2(Duck duck){
        this.duck = duck;
        random = new Random(10);
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        if(random.nextInt() > 0) {
            duck.fly();
        }else{
            System.out.println("I'm too lasy to fly.");
        }
    }
}
