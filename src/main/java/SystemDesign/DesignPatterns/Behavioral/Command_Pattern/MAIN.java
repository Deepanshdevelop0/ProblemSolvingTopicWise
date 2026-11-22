package SystemDesign.DesignPatterns.Behavioral.Command_Pattern;

import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.impl.Fan_Command;
import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.impl.Light_Command;
import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.model.Fan;
import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.model.Light;

public class MAIN {

    public static void main(String[] args) {

        Light livingRoomLight = new Light();
        Fan livingRoomFan = new Fan();

        Remote_Controller remote = new Remote_Controller();

        remote.setCommand(0, new Light_Command(livingRoomLight));
        remote.setCommand(1, new Fan_Command(livingRoomFan));


        System.out.println("--- Toggling light button ---");
        remote.pressbutton(0); // ON
        remote.pressbutton(0); // OFF

        System.out.println("--- Toggling Fan button ---");
        remote.pressbutton(1); // ON
        remote.pressbutton(1); // OFF

        System.out.println("--- Pressing unassigned button ---");
        remote.pressbutton(2); // throw exception

        System.gc();
    }
}
