package headfirst.command.undo;

/**
 * Created by igors on 5/24/15.
 */
public class CeilingFanOffCommand_My extends CeilingFanCommand_My {

    public CeilingFanOffCommand_My(CeilingFan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed  = fan.getSpeed();
        fan.off();
    }

    @Override
    public void undo() {
        super.undo();
    }
}
