package headfirst.composite.menuiterator;

 
import java.util.*;
  
public class CompositeIterator implements Iterator {
	Stack stack = new Stack();
   
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}
   
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek(); //get iterator from the stack
			//the "stack" will "peek" (select) top iterator in the stack, until "hasNext()" method below in this class
			//calls "pop" for that iterator, when no "next" elements are remaining in it
			MenuComponent component = (MenuComponent) iterator.next(); //iterator returns next element
			if (component instanceof Menu) {
				//if element returned by iterator is Menu, then create CompositeIterator for it and push it at the top of
				// the stack of the current CompositeIterator
				//on next iteration "stack.peek()" will return THE NEW CompositeIterator, because it will be at the top of the stack
				stack.push(component.createIterator());
			} 
			return component;
		} else {
			return null;
		}
	}
  
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if (!iterator.hasNext()) {
				stack.pop(); //drop current iterator from the stack
				return hasNext();  //start checking in following iterator in the stack "has Next" element
			} else {
				return true;
			}
		}
	}
   
	public void remove() {
		throw new UnsupportedOperationException();
	}
}


