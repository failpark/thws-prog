package L04;

import java.util.Scanner;

public class UZ_NotenRI {

	private static final double PUNKT_ABSTAND = 4.5;
	private static final double START_PUNKTE = 85.5;
	private static final double[] NOTEN = {1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0};

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

		System.out.println();
		zeige_notentabelle();

		double note = berechne_note(punktzahl);
		System.out.println("\nSie haben die Note " + formatiere_note(note) + " erreicht.");

	}

	private static boolean ist_bereich_gueltig(double punktzahl) {
		return punktzahl >= 0 && punktzahl <= 90;
	}

	private static boolean ist_dezimalstelle_gueltig(double punktzahl) {
		double dezimalteil = punktzahl - (int)punktzahl;
		return dezimalteil == 0.0 || dezimalteil == 0.5;
	}

	private static void zeige_notentabelle() {
		System.out.println("Punte\tNote");
		System.out.println();

		for (int i = 0; i < NOTEN.length; i++) {
			double punkte = berechne_punktgrenze(i);
			System.out.println("ab " + formatiere_punkte(punkte) + "\t" + formatiere_note(NOTEN[i]));
		}
	}

	private static double berechne_punktgrenze(int index) {
		return START_PUNKTE - (index * PUNKT_ABSTAND);
	}

	private static double berechne_note(double punktzahl) {
		for (int i = 0; i < NOTEN.length; i++) {
			double grenze = berechne_punktgrenze(i);
			if (punktzahl >= grenze) {
				return NOTEN[i];
			}
		}
		return 5.0;
	}

	private static String formatiere_note(double note) {
		if (note == Math.floor(note)) {
			return String.valueOf((int) note);
		}
		return String.valueOf(note);
	}

	private static String formatiere_punkte(double punkte) {
		if (punkte == Math.floor(punkte)) {
			return String.format("%.1f", punkte);
		}
		return String.valueOf(punkte);
	}
}