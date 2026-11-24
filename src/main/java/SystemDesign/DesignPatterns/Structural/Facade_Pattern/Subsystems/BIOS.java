package SystemDesign.DesignPatterns.Structural.Facade_Pattern.Subsystems;

public class BIOS {

    public void boot(CPU cpu, Memory memory) {
        System.out.println("---- Started BIOS boot process ----");
        cpu.start();
        memory.load();
        System.out.println("---- Finished BIOS boot process ----");
    }

}
