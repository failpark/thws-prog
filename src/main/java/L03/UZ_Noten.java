package L03;

import java.util.Scanner;

public class UZ_Noten {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ihre Note wird ermittelt.");
		System.out.print("Bitte geben Sie Ihre Punktzahl ein: ");

		double punktzahl = scanner.nextDouble();
		scanner.close();

		if (!ist_bereich_gueltig(punktzahl)) {
			System.out.println("Die Punktzahl muss zwischen 0 und 90 liegen.");
			return;
		}

		if (!ist_dezimalstelle_gueltig(punktzahl)) {
			System.out.println("Sie dürfen nur ganze Zahlen oder Zahlen, die auf ,5 enden eingeben.");
			return;
		}

		double note = berechne_note(punktzahl);
		System.out.println("Sie haben die Note " + formatiere_note(note) + " erreicht.");
	}

	private static boolean ist_bereich_gueltig(double punktzahl) {
		return punktzahl >= 0 && punktzahl <= 90;
	}

	private static boolean ist_dezimalstelle_gueltig(double punktzahl) {
		double dezimalteil = punktzahl - Math.floor(punktzahl);
		return dezimalteil == 0.0 || dezimalteil == 0.5;
	}

	private static double berechne_note(double punktzahl) {
		if (punktzahl >= 85.5) return 1.0;
		if (punktzahl >= 81.0) return 1.3;
		if (punktzahl >= 76.5) return 1.7;
		if (punktzahl >= 72.0) return 2.0;
		if (punktzahl >= 67.5) return 2.3;
		if (punktzahl >= 63.0) return 2.7;
		if (punktzahl >= 58.5) return 3.0;
		if (punktzahl >= 54.0) return 3.3;
		if (punktzahl >= 49.5) return 3.7;
		if (punktzahl >= 44.5) return 4.0;
		return 5.0;
	}

	private static String formatiere_note(double note) {
		if (note == Math.floor(note)) {
			return String.valueOf((int) note);
		}
		return String.valueOf(note);
	}
}