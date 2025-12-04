package L05;

public class PI_Archimedes {
	public static void main(String[] args) {
		int n = 6;
		// Seitenlänge reguläres Sechseck im Einheitskreis
		double sideLength = 1.0;
		int max_iterations = 10;
		for (int iteration = 0; iteration < max_iterations; iteration++) {
			double perimeter = n * sideLength;
			double piApprox = perimeter / 2.0;
			double difference = Math.PI - piApprox;

			System.out.println(n + "-Vieleck: Pi = \t" + piApprox + " Diff zu Math.PI:\t\t " + difference);

			// Archimedes-Methode: Verdopple die Eckenanzahl durch Halbierung des Mittelpunktswinkels
			// Aus der Geometrie folgt: s_neu² = 2 - sqrt(4 - s_alt²)
			// Dies approximiert π von unten, da der Umfang des Vielecks < 2π (Kreisumfang)
			sideLength = sqrt(2.0 - sqrt(4.0 - sideLength * sideLength));
			n = n * 2;
		}
	}

	// Newton's method for square root (since we can't use Math.sqrt)
	private static double sqrt(double number) {
		if (number == 0) return 0;
		if (number < 0) return 0;

		double guess = number / 2.0;
		double epsilon = 0.00000000001; // Precision
		while (true) {
			double newGuess = (guess + number / guess) / 2.0;
			double diff = guess - newGuess;
			if (diff < 0) diff = -diff; // Absolute value

			if (diff < epsilon) {
				return newGuess;
			}
			guess = newGuess;
		}
	}
}