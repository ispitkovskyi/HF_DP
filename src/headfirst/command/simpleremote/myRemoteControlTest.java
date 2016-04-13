package headfirst.command.simpleremote;

import java.util.Arrays;

/**
 * Created by igors on 5/11/15.
 */
public class myRemoteControlTest {
    public static void main (String args[]) {
        SimpleRemoteControl remote = new SimpleRemoteControl();

        GarageDoor garageDoor = new GarageDoor();
        myGarageDoorOpenCommand myGarageDoorOpenCommand = new myGarageDoorOpenCommand(garageDoor);
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        remote.setCommand(myGarageDoorOpenCommand);
        remote.buttonWasPressed();
    }
}
