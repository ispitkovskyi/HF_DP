package headfirst.command.party;

/**
 * Created by igors on 5/24/15.
 */
public class MacroCommand_My implements Command {
    Command[] commands;

    public MacroCommand_My(Command[] commands){
        this.commands = commands;
    }

    @Override
    public void execute() {
        for(int i=0; i<commands.length; i++){
            commands[i].execute();
        }
    }

    //Undo commands have to be set in reversed order
    @Override
    public void undo() {
        for(int i=commands.length-1; i>-1; i--){
            commands[i].undo();
        }
    }
}
