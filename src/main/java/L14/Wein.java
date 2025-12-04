package L14;

public abstract class Wein extends Getraenke {
	int jahrgang;
	public Wein(String herkunft, String sorte, double alk, int jahrgang) {
		super(herkunft, sorte, alk);
		this.jahrgang = jahrgang;
	}

	public static double[] test() {
		return new double[] {1.0, 2.0};
	}
}
