package headfirst.proxy.gumball;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

			Registry registry = LocateRegistry.getRegistry();
			registry.bind("//" + args[0] + "/gumballmachine", gumballMachine);
			System.out.println("Waiting for requests");
			/*IgorS: Next line of code (initially existed in this project) does NOT work, dropping exception:
				java.rmi.UnknownHostException: Unknown host: seattle.mightyball.com; nested exception is:
				java.net.UnknownHostException: seattle.mightyball.com
				at sun.rmi.transport.tcp.TCPEndpoint.newSocket(TCPEndpoint.java:616)
			*
			Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
