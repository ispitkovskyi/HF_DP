package headfirst.templatemethod.sort;

import java.util.Arrays;

/**
 * Created by igors on 15.11.15.
 */
public class myDuckSortTestDrive {

    public static void main(String []args){
        myDuck [] myDucks = {
                new myDuck("Daffy", 8),
                new myDuck("Dewey", 2),
                new myDuck("Howard", 7),
                new myDuck("Louie", 2),
                new myDuck("Donald", 10),
                new myDuck("Huey", 2)
        };

        System.out.println("BEFORE SORTING");
        display(myDucks);

        Arrays.sort(myDucks);

        System.out.println("\n\n\n AFTER SORTING");
        display(myDucks);
    }

    public static void display(myDuck [] ducks){
        for(int i=0; i<ducks.length; i++){
            System.out.println(ducks[i]);
        }
    }
}
