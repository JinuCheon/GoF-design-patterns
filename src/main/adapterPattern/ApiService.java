package main.adapterPattern;

public class ApiService {
    private final Encryptor encryptor;

    public ApiService(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

    public void sendRequest(String requestBody) {
        String encryptedBody = encryptor.encrypt(requestBody);
        System.out.println("암호화된 요청 데이터: " + encryptedBody);
    }
}