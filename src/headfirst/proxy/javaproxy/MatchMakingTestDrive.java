package headfirst.proxy.javaproxy;

import java.lang.reflect.*;
import java.util.*;

public class MatchMakingTestDrive {
	Hashtable datingDB = new Hashtable();
 	
	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();
		test.drive();
	}
 
	public MatchMakingTestDrive() {
		initializeDatabase();
	}

	public void drive() {
		PersonBean joe = getPersonFromDatabase("Joe Javabean"); 
		PersonBean ownerProxy = getOwnerProxy(joe);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests("bowling, Go");
		System.out.println("Interests set from owner proxy");
		try {
			ownerProxy.setHotOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
		System.out.println("Name is " + nonOwnerProxy.getName());
		try {
			nonOwnerProxy.setInterests("bowling, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		nonOwnerProxy.setHotOrNotRating(3);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());

		//code to test my "NonOwnerInvocationHandler2" class
		PersonBean kelly = getPersonFromDatabase("Kelly Klosure");
		PersonBean nonOwnerProxy2 = getNonOwner2Proxy(kelly);
		System.out.println("IGORS_PROXY Name is " + nonOwnerProxy2.getName());
		try {
			nonOwnerProxy2.setInterests("riding bike, Go");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		nonOwnerProxy2.setHotOrNotRating(5);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy2.getHotOrNotRating());
	}

	PersonBean getOwnerProxy(PersonBean person) {
 		
        return (PersonBean) Proxy.newProxyInstance( 
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
	}

	PersonBean getNonOwnerProxy(PersonBean person) {
		
        return (PersonBean) Proxy.newProxyInstance(
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
	}

	PersonBean getPersonFromDatabase(String name) {
		return (PersonBean)datingDB.get(name);
	}

	void initializeDatabase() {
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		datingDB.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		datingDB.put(kelly.getName(), kelly);
	}

	//Create instance of proxy-object for personBean, having NonOwnerInvocationHandler2 class used as "proxy requests handler"
	PersonBean getNonOwner2Proxy(PersonBean personBean){
		return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
					personBean.getClass().getInterfaces(),
					new NonOwnerInvocationHandler2(personBean));
	}
}
