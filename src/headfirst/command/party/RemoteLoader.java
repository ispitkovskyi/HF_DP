package headfirst.command.party;

public class RemoteLoader {

	public static void main(String[] args) {

		RemoteControl remoteControl = new RemoteControl();

		Light light = new Light("Living Room");
		TV tv = new TV("Living Room");
		Stereo stereo = new Stereo("Living Room");
		Hottub hottub = new Hottub();
 
		LightOnCommand lightOn = new LightOnCommand(light);
		StereoOnCommand stereoOn = new StereoOnCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		LightOffCommand lightOff = new LightOffCommand(light);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOffCommand tvOff = new TVOffCommand(tv);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);

		Command[] partyOn = { lightOn, stereoOn, tvOn, hottubOn};
		Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff};
  
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
 
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
  
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);


		/* MY CODE */
		System.out.println("\n\n--- MY CODE TESTING ---");
		MacroCommand_My partyOnMacroMy = new MacroCommand_My(partyOn);
		MacroCommand_My partyOffMacroMy = new MacroCommand_My(partyOff);
		remoteControl.setCommand(1, partyOnMacroMy, partyOffMacroMy);
		System.out.println("\n--- Pushing Macro MY On, then Undo ---");
		remoteControl.onButtonWasPushed(1);
		System.out.println("--- Now Undo on-commands:");
		remoteControl.undoButtonWasPushed();
		System.out.println("\n--- Pushing Macro MY Off, then Undo ---");
		remoteControl.offButtonWasPushed(1);
		System.out.println("--- Now Undo off-commands:");
		remoteControl.undoButtonWasPushed();
	}
}
