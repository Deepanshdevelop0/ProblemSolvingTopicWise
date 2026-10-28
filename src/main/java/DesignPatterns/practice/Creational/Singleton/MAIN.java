package DesignPatterns.practice.Creational.Singleton;

public class MAIN {

    /*

    Your Spring Boot microservice needs to fetch secrets from Azure Key Vault.
    How do you ensure that only a single,
    shared instance of the AzureKeyVaultClient is instantiated across the entire application to prevent memory leaks and redundant network calls?

    */

    public static void main(String[] args) {
        AzureKeyVaultClient keyVaultClient = AzureKeyVaultClient.getInstance();
        System.out.println(keyVaultClient.getPath());

        AzureKeyVaultClient keyVaultClient1 = AzureKeyVaultClient.getInstance();
        System.out.println(keyVaultClient1.getPath());
    }
}
