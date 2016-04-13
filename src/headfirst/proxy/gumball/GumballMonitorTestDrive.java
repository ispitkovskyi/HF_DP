package headfirst.proxy.gumball;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GumballMonitorTestDrive {
 
	public static void main(String[] args) {
		String[] location = {"rmi://santafe.mightygumball.com/gumballmachine",
		                     "rmi://boulder.mightygumball.com/gumballmachine",
		                     "rmi://seattle.mightygumball.com/gumballmachine"};
		Registry registry = null;

		if (args.length >/* = */ 0)
        {
			System.out.println(String.format("Using custom location of GumballMachine service instead of hardcoded samples. IP: %s",args[0]));
			location = new String[1];

			/* IgorS: Commented "rmi:" below, because when I get list of services registered in rmi registry it shows something like
			* "//192.168.0.105/gumballmachine" instead of "rmi://192.168.0.105/gumballmachine"
			* so, it simply didn't work with rmi:
			*/
            location[0] = /*"rmi:*/"//" + args[0] + "/gumballmachine";
        }
		
		GumballMonitor[] monitor = new GumballMonitor[location.length];

		try {
			registry = LocateRegistry.getRegistry();
		}catch(Exception e){
			System.out.println("Could not get rmi registry instance.");
			return;
		}

		for (int i=0;i < location.length; i++) {
			try {
				/* IgorS: Used "getRegistry" (above) and then lookup of registry-object (below)
				* to avoid following error:
				* Trying custom location: #192.168.0.105 (or whatever IP machine with server-part running has)
				* java.rmi.NotBoundException: gumballmachine
				*
           		// GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
				*/


				String[]servicesRunning = registry.list();
				System.out.println("\nList of all services running in the jre: ------ ");
				for(int j=0; j<servicesRunning.length;j++){
					System.out.println("Service #" + j + ": " + servicesRunning[j]);
				}
				System.out.println("---------------------------------- ");

				//Following method ".lookup" returns stub-object of remotely running instance of GumballMachine
				//Метод "lookup()" создает экземпляр класса-ЗАМЕСТИТЕЛЯ (stub)
				GumballMachineRemote machine = (GumballMachineRemote) registry.lookup(location[i]);
				System.out.println("\nLocation of machine to be used: #" + i + " - " + machine.getLocation());

           		monitor[i] = new GumballMonitor(machine);
				System.out.println("\nMONITOR: -----------");
				System.out.println(monitor[i]);
				System.out.println("-----------------------");

        	} catch (Exception e) {
            	e.printStackTrace();
        	}
		}

		System.out.println("\n\nREPORTS");
		for(int i=0; i < monitor.length; i++) {
			System.out.println(String.format("===== Monitor #%s =====",i));
			monitor[i].report();
			System.out.println("======================");
		}
	}
}
