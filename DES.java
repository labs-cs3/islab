import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESExample {

    public static void main(String[] args) throws Exception {
        String originalString = "Hello, World!";
        String key = "12345678"; // Key must be 8 bytes for DES

        byte[] encryptedBytes = encrypt(originalString, key);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedBytes));

        String decryptedString = decrypt(encryptedBytes, key);
        System.out.println("Decrypted: " + decryptedString);
    }

    public static byte[] encrypt(String plainText, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(byte[] cipherText, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }
}
