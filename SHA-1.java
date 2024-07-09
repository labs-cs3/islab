import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class SHA1Digest {

    // Method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // Method to compute SHA-1 hash
    public static String computeSHA1(String input) {
        try {
            // Create a SHA-1 digest instance
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

            // Update the digest with the input bytes
            byte[] hashBytes = sha1.digest(input.getBytes());

            // Convert the byte array to a hex string
            return bytesToHex(hashBytes);

        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if SHA-1 algorithm is not available
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input text from the user
        System.out.print("Enter text to hash: ");
        String inputText = scanner.nextLine();

        // Compute the SHA-1 hash of the input text
        String sha1Hash = computeSHA1(inputText);

        // Display the SHA-1 hash
        System.out.println("SHA-1 Hash: " + sha1Hash);

        scanner.close();
    }
}
