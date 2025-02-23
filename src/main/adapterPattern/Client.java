package main.adapterPattern;

public class Client {
    public static void main(String[] args) {
        ExternalEncryptor externalEncryptor = new ExternalEncryptor();
        Encryptor encryptor = new EncryptorAdapter(externalEncryptor);
        ApiService apiService = new ApiService(encryptor);
        apiService.sendRequest("Hello, Adapter Pattern!");
    }
}