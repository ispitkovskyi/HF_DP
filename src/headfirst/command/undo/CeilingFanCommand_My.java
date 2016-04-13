package headfirst.command.undo;

/**
 * Created by igors on 5/24/15.
 */
public abstract class CeilingFanCommand_My implements Command {
    CeilingFan fan;
    protected int prevSpeed;

    @Override
    public abstract void execute();

    public void undo() {
        if(prevSpeed == CeilingFan.HIGH){
            fan.high();
        }else if(prevSpeed==CeilingFan.MEDIUM){
            fan.medium();
        }else if(prevSpeed==CeilingFan.LOW){
            fan.low();
        }else if(prevSpeed==CeilingFan.OFF){
            fan.off();
        }
    }
}
