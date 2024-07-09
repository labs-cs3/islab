import java.util.Scanner;

public class CaesarCipherDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCaesar Cipher - Decryption");
        System.out.print("Enter Message To Decrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter Key: ");
        int key = scanner.nextInt();

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = (char) (c - key);
                if (c < 'a') {
                    c = (char) (c + 'z' - 'a' + 1);
                }
                decryptedText.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) (c - key);
                if (c < 'A') {
                    c = (char) (c + 'Z' - 'A' + 1);
                }
                decryptedText.append(c);
            } else {
                decryptedText.append(c);
            }
        }

        System.out.println("Decrypted Text: " + decryptedText.toString());
    }
}
