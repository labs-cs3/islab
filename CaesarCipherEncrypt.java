import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCaesar Cipher - Encryption");
        System.out.print("Enter Message To Encrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter Key: ");
        int key = scanner.nextInt();

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char) (c + key);
                if (c > 'z') {
                    c = (char) (c - 'z' + 'a' - 1);
                }
                encryptedText.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) (c + key);
                if (c > 'Z') {
                    c = (char) (c - 'Z' + 'A' - 1);
                }
                encryptedText.append(c);
            } else {
                encryptedText.append(c);
            }
        }

        System.out.println("\nEncrypted Message: " + encryptedText.toString());
    }
}