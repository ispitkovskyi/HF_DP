package headfirst.command.simpleremote;

/**
 * Created by igors on 5/11/15.
 */
public class myGarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public myGarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
