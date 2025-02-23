package main.adapterPattern;

/**
 * Adapter.
 * 객체적응자 방식.
 */
public class EncryptorAdapter implements Encryptor {
    private final ExternalEncryptor externalEncryptor;

    public EncryptorAdapter(ExternalEncryptor externalEncryptor) {
        this.externalEncryptor = externalEncryptor;
    }

    @Override
    public String encrypt(String data) {
        return externalEncryptor.encryptData(data);
    }
}