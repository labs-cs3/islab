import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class BlowfishExample {

    public static void main(String[] args) throws Exception {
        String originalString = "Hello, World!";
        String keyString = "ThisIsASecretKey"; 

        byte[] encryptedBytes = encrypt(originalString, keyString);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedBytes));

        String decryptedString = decrypt(encryptedBytes, keyString);
        System.out.println("Decrypted: " + decryptedString);
    }

    public static byte[] encrypt(String plainText, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(byte[] cipherText, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("Blowfish");
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), "Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }
}
