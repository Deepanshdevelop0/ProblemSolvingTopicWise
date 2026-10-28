package DesignPatterns.practice.Creational.Builder;

import DesignPatterns.practice.Creational.Builder.objectBuilder.AzureVmDeploymentConfig;

public class MAIN {

    /*

    You are writing a cloud automation script that provisions Azure VM instances.
    The VM requires a mandatory OS and RAM size, but has dozens of optional configurations (GPU type, SSD storage, virtual network rules, tags).
    How do you construct this complex AzureVmDeploymentConfig object cleanly without creating a constructor that takes 20 parameters?

    */
    public static void main(String[] args) {

        AzureVmDeploymentConfig azureVmDeploymentConfig = new AzureVmDeploymentConfig.Builder(16, AzureVmDeploymentConfig.OS.WINDOWS)
                .setSsdStorage(1024)
                .setRegion(AzureVmDeploymentConfig.Region.US)
                .setVnRules(null)
                .setTags(null)
                .build(); 

    }
}
