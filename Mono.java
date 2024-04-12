import java.io.*;
import java.util.Scanner;

class Mono {
	public static char n[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static char c[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
			'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M' };

	public static String encrypt(String s) {
		String es = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (s.charAt(i) == n[j]) {
					es += c[j];
					break;
				}
			}
		}
		return es;
	}

	public static String decrypt(String s) {
		String ds = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (s.charAt(i) == c[j]) {
					ds += n[j];
					break;
				}
			}
		}
		return ds;
	}

	public static void main(String args[]) {
		System.out.println("Enter plain text:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("Plain text: " + str);
		String estr = encrypt(str.toLowerCase());
		System.out.println("Encrypted message: " + estr);
		System.out.println("Decrypted message: " + decrypt(estr));

	}
}
