package L20.MauMauGeneric;

public class French_Suited implements Card<French_Suited> {
	Weight weight;
	Kind kind;

	public French_Suited(Kind k, Weight w) {
		this.weight = w;
		this.kind = k;
	}

	public int compareTo(French_Suited o) {
		if (this.weight == Weight.BUBE || o.weight == Weight.BUBE) {
			return compare_bube(o);
		}
		int kind = this.kind.compareTo(o.kind);
		if (kind != 0) {
			return kind;
		}
		return this.weight.compareTo(o.weight);
	}

	private int compare_bube(French_Suited o) {
		int weight = this.weight.compareTo(o.weight);
		if (weight != 0) {
			return weight;
		}
		return this.kind.compareTo(o.kind);
	}

	public String toString() {
		return this.kind + " — " + this.weight;
	}
}
