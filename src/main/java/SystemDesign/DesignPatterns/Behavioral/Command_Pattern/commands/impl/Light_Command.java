package SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.impl;

import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.Command;
import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.model.Light;

public class Light_Command extends Command {

    Light light = null;
    boolean isPressed;

    public Light_Command(Light light) {
        this.light = light;
        this.isPressed = false;
    }
    @Override
    public void execute() {
        light.on();
        this.isPressed = true;
    }
    @Override
    public void undo() {
        light.off();
        this.isPressed = false;
    }

}
