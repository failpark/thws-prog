package L20.MauMauGeneric;

public enum Kind {
	KREUZ,
	PIK,
	HERZ,
	KARO;
	
	public String toString() {
		return switch(this){
			case KREUZ -> "♣";
			case PIK -> "♠";
			case HERZ -> "♥";
			case KARO -> "♦";
		};
	}
}
