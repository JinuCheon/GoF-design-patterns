package main.adapterPattern;

/**
 * adaptee.
 * 업체에서 제공한 외부 라이브러리.
 * <p>
 * 관심없는 기능들이 모두 모여있다.
 * 우리는 여기서 encryptData 메서드만 사용하고 싶다.
 */
public class ExternalEncryptor {
    public String encryptData(String plainText) {
        return new StringBuilder(plainText).reverse().toString();
    }

    public void trashMethod() {
        System.out.println("Trash method");
    }

    public void trashMethod2() {
        System.out.println("Trash method2");
    }
}