package L05;

import java.util.Scanner;

public class SummeScanner {
	public static void main(String[] args) {
		int sum = 0;
		System.out.println("Ihre eingegebenen ganzen Zahlen werden addiert.");
		System.out.println("Die Eingabe von 0 beendet das Programm und gibt die Summe aus!");
		Scanner scan = new Scanner(System.in);
		while (true) {
			int in = scan.nextInt();
			if (in == 0) break;

			sum += in;
		}
		System.out.println("Summe: " + sum);
	}
}
