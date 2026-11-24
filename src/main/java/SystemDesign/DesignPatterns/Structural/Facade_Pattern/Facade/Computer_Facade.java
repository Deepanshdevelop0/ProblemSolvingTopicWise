package SystemDesign.DesignPatterns.Structural.Facade_Pattern.Facade;

import SystemDesign.DesignPatterns.Structural.Facade_Pattern.Subsystems.*;

public class Computer_Facade {

    private CPU cpu;
    private BIOS bios;
    private CoolingSystem coolingSystem;
    private OperatingSystem os;
    private Memory memory;

    public Computer_Facade() {
        this.cpu = new CPU();
        this.bios = new BIOS();
        this.coolingSystem = new CoolingSystem();
        this.os = new OperatingSystem();
        this.memory = new Memory();
    }

    public void startComputer() {
        System.out.println("---- Starting Computer ----");

        coolingSystem.startFans();
        bios.boot(cpu, memory);
        os.load();

        System.out.println("---- Computer Started ----");
    }

}
