import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        int[][] a = {
            {6, 24, 1},
            {13, 16, 10},
            {20, 17, 15}
        };
        int[][] b = {
            {8, 5, 10},
            {21, 8, 21},
            {21, 12, 8}
        };
        int[] c = new int[20];
        int[] d = new int[20];
        char[] msg = new char[20];
        int determinant = 0, t = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter plain text:");
        String message = scanner.next().toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            c[i] = message.charAt(i) - 65;
            System.out.print(c[i] + " ");
        }

        for (int i = 0; i < 3; i++) {
            t = 0;
            for (int j = 0; j < 3; j++) {
                t = t + (a[i][j] * c[j]);
            }
            d[i] = t % 26;
        }

        System.out.print("\nEncrypted Cipher Text :");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + (char)(d[i] + 65));
        }

        for (int i = 0; i < 3; i++) {
            t = 0;
            for (int j = 0; j < 3; j++) {
                t = t + (b[i][j] * d[j]);
            }
            c[i] = t % 26;
        }

        System.out.print("\nDecrypted Cipher Text :");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + (char)(c[i] + 65));
        }

        scanner.close();
    }
}
