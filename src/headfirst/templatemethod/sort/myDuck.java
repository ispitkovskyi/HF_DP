package headfirst.templatemethod.sort;

/**
 * Created by igors on 15.11.15.
 */
public class myDuck implements Comparable {
    String name;
    int weight;
    public myDuck (String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        return name + " weights " + weight;
    }

    @Override
    public int compareTo(Object o) {
        myDuck otherDuck = (myDuck) o;
        if(this.weight > otherDuck.weight){
            return 1;
        }else if(this.weight == otherDuck.weight){
            return 0;
        }else{
            return -1;
        }
    }
}
