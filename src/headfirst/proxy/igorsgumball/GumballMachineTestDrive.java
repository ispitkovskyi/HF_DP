package headfirst.proxy.igorsgumball;

import headfirst.proxy.gumball.GumballMachine;
import headfirst.proxy.gumball.GumballMachineRemote;

import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachineTestDrive {
 
	public static void main(String[] args) {
		GumballMachineRemote gumballMachine = null;
		int count;

		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
 			System.exit(1);
		}

		try {
			count = Integer.parseInt(args[1]);

			gumballMachine =
				new GumballMachine(args[0], count);
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
			GumballMachineRemote gumballMachineStub = (GumballMachineRemote)UnicastRemoteObject.exportObject(gumballMachine, 8081);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
