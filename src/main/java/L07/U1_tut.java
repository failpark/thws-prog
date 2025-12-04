package L07;

import java.util.Scanner;

public class U1_tut {
	public static void main(String[] args) {
		System.out.println("Bitte geben Sie eine Zahl ein:");
		Scanner in = new Scanner(System.in);


	}
	private static double power(double b, double c) {
		double h = 1;
		for (int i = 0; i < c; i++) {
			h = b * h;
		}
		return h;
	}


}
