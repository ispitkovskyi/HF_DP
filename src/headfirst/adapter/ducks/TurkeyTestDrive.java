package headfirst.adapter.ducks;

public class TurkeyTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		Turkey duckAdapter = new DuckAdapter(duck);
		Turkey duckAdapter2 = new DuckAdapter2(duck);
 
		for(int i=0;i<10;i++) {
			System.out.println("The DuckAdapter says...");
			duckAdapter.gobble();
			duckAdapter.fly();
		}
		System.out.println("\n\nFollowing example is mine:");

		for(int i=0; i<10; i++){
			System.out.println("My DuckAdapter says:...");
			duckAdapter2.gobble();
			duckAdapter2.fly();
		}
	}
}
