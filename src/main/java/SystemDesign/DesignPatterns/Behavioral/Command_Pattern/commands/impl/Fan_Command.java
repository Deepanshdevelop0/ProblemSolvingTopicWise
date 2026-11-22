package SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.impl;

import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.Command;
import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.model.Fan;

public class Fan_Command extends Command {

    Fan fan = null;
    boolean isPressed;


    public Fan_Command(Fan fan) {
        this.fan = fan;
        this.isPressed = false;
    }

    @Override
    public void execute() {
        fan.on();
        this.isPressed = true;
    }

    @Override
    public void undo() {
        fan.off();
        this.isPressed = false;
    }

}
