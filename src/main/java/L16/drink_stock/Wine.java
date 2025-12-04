package L16.drink_stock;

public abstract class Wine extends Drink {
	private int year;

	public Wine(String name, String origin, String kind, float alcoholic_content, int year) {
		super(name, origin, kind, alcoholic_content);
		this.year = year;
	}

	String basic_out() {
		return super.basic_out() + "\nJahrgang: " + this.year;
	}
}
