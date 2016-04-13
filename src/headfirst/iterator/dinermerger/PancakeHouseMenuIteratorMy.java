package headfirst.iterator.dinermerger;

import java.util.ArrayList;

/**
 * Created by igors on 25.11.15.
 */
public class PancakeHouseMenuIteratorMy implements Iterator {
    ArrayList menuItems;
    int position = 0;

    public PancakeHouseMenuIteratorMy(ArrayList menuItems){
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.size() || menuItems.get(position) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
        Object item = menuItems.get(position);
        position = position + 1;
        return item;
    }
}
