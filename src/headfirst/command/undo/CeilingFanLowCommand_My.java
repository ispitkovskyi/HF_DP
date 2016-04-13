package headfirst.command.undo;

import headfirst.command.simpleremote.*;

/**
 * Created by igors on 5/24/15.
 */
public class CeilingFanLowCommand_My extends CeilingFanCommand_My{

    public CeilingFanLowCommand_My(CeilingFan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.low();
    }

    @Override
    public void undo() {
       super.undo();
    }


}
