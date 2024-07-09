import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class RSAExample {

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Original message
        String originalMessage = "Hello, World!";
        System.out.println("Original Message: " + originalMessage);

        // Encrypt the message using public key
        byte[] encryptedMessage = encrypt(originalMessage, publicKey);
        // System.out.println("Encrypted Message: " + new String(encryptedMessage));
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encryptedMessage));

        String decryptedMessage = decrypt(encryptedMessage, privateKey);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size 2048 bits
        return keyPairGenerator.generateKeyPair();
    }

    public static byte[] encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plainText.getBytes());
    }

    public static String decrypt(byte[] cipherText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes);
    }
}
