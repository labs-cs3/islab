import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class DiffieHellman {

    // Generate a random prime number of the specified bit length
    private static BigInteger generatePrime(int bitLength) {
        SecureRandom random = new SecureRandom();
        return BigInteger.probablePrime(bitLength, random);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate a large prime number (p) and a primitive root modulo p (g)
        int bitLength = 512; // or another suitable length like 2048
        BigInteger p = generatePrime(bitLength);
        BigInteger g = BigInteger.valueOf(2); // Choosing 2 as the primitive root (in practice, this should be verified)

        // Display the chosen prime (p) and generator (g)
        System.out.println("Prime (p): " + p);
        System.out.println("Generator (g): " + g);

        // User A's private key
        System.out.print("Enter User A's private key (a): ");
        BigInteger a = new BigInteger(scanner.next());

        // User B's private key
        System.out.print("Enter User B's private key (b): ");
        BigInteger b = new BigInteger(scanner.next());

        // Calculate public keys
        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);

        // Display the public keys
        System.out.println("User A's Public Key (A): " + A);
        System.out.println("User B's Public Key (B): " + B);

        // Calculate the shared secret keys
        BigInteger sharedKeyA = B.modPow(a, p); // A calculates the shared key
        BigInteger sharedKeyB = A.modPow(b, p); // B calculates the shared key

        // Display the shared secret keys
        System.out.println("User A's Shared Secret Key: " + sharedKeyA);
        System.out.println("User B's Shared Secret Key: " + sharedKeyB);

        scanner.close();

        // Verify that both shared keys are the same
        if (sharedKeyA.equals(sharedKeyB)) {
            System.out.println("Key Exchange Successful. Shared secret is: " + sharedKeyA);
        } else {
            System.out.println("Key Exchange Failed.");
        }
    }
}
