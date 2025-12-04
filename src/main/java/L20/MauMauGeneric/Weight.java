package L20.MauMauGeneric;

public enum Weight {
	BUBE,
	ASS,
	ZEHN,
	KOENIG,
	DAME,
	NEUN,
	ACHT,
	SIEBEN;

	public String toString() {
		return switch(this) {
			case BUBE -> "B";
			case ASS -> "A";
			case ZEHN -> "10";
			case KOENIG -> "K";
			case DAME -> "D";
			case NEUN -> "9";
			case ACHT -> "8";
			case SIEBEN -> "7";
		};
	}
}
