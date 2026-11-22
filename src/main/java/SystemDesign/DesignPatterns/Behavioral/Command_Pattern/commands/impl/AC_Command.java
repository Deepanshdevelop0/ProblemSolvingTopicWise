package SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.impl;

import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.Command;
import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.model.Air_Conditioner;

public class AC_Command extends Command {

    private Air_Conditioner ac = null;
    boolean isPressed;

    public AC_Command(Air_Conditioner ac) {
        this.ac = ac;
        this.isPressed = false;
    }

    @Override
    public void execute() {
        ac.on();
        this.isPressed = true;
    }

    @Override
    public void undo() {
        ac.off();
        this.isPressed = false;
    }
}
