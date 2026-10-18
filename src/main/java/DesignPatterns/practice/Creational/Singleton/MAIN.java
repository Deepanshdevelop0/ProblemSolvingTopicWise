package DesignPatterns.practice.Creational.Singleton;

public class MAIN {

    public static void main(String[] args) {
        AzureKeyVaultClient keyVaultClient = AzureKeyVaultClient.getInstance();
        System.out.println(keyVaultClient.getPath());

        AzureKeyVaultClient keyVaultClient1 = AzureKeyVaultClient.getInstance();
        System.out.println(keyVaultClient1.getPath());
    }
}
