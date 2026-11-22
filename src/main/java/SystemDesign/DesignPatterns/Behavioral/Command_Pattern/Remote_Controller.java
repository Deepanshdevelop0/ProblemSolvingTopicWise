package SystemDesign.DesignPatterns.Behavioral.Command_Pattern;

import SystemDesign.DesignPatterns.Behavioral.Command_Pattern.commands.Command;

import java.util.Arrays;

public class Remote_Controller {

    private static final int numOfBtns = 3;
    private Command[] commandsList;
    private boolean[] isButtonPressed;

    public Remote_Controller() {
        commandsList = new Command[numOfBtns];
        Arrays.fill(commandsList, null);
        isButtonPressed = new boolean[numOfBtns];
    }

    public void setCommand(int indx, Command command) {
        if (indx >= 0 && indx < numOfBtns) {
            commandsList[indx] = command;
            isButtonPressed[indx] = false;
        }
    }

    public void pressbutton(int indx) {
        if (indx >= 0 && indx < numOfBtns && commandsList[indx] != null) {
            if (isButtonPressed[indx]) commandsList[indx].undo();
            else commandsList[indx].execute();
            isButtonPressed[indx] = !isButtonPressed[indx];
        }
        else {
            System.out.println("No command assigned to the button!");
        }
    }

}
