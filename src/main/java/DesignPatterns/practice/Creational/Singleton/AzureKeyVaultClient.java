package DesignPatterns.practice.Creational.Singleton;

public class AzureKeyVaultClient {

    private static AzureKeyVaultClient keyVaultClient;
    private static String path;
    private AzureKeyVaultClient() {
        path = "/../../clientPath.json";
    }

    public static AzureKeyVaultClient getInstance() {

        if (keyVaultClient == null) {
            synchronized (AzureKeyVaultClient.class) {
                if (keyVaultClient == null) {
                    keyVaultClient = new AzureKeyVaultClient();
                }
            }
        }

        return keyVaultClient;
    }

    public String getPath() {
        return path;
    }

}
