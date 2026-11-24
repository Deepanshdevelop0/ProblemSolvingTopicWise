package SystemDesign.DesignPatterns.Structural.Facade_Pattern;

import SystemDesign.DesignPatterns.Structural.Facade_Pattern.Facade.Computer_Facade;

public class Client {

    private static Computer_Facade computerFacade;

    public static void main(String[] args) {

        computerFacade = new Computer_Facade();
        computerFacade.startComputer();
    }

}
