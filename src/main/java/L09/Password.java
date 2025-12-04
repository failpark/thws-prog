package L09;

public class Password {

	private String password;
	private String created_from;
	private int nr_of_special_chars;
	private int nr_of_digits;

	public Password(String sentence) {
		this.password = "";
		this.created_from = sentence;
		this.nr_of_special_chars = 0;
		this.nr_of_digits = 0;
	}

	public void addCharToPassword(char c, boolean is_special_char, boolean is_digit) {
		this.password = this.password + c;

		if (is_special_char) {
			this.nr_of_special_chars++;
		}

		if (is_digit) {
			this.nr_of_digits++;
		}
	}

	public boolean validate() {
		int length = this.password.length();

		if (length < 8 || length > 15) {
			return false;
		}

		if (this.nr_of_special_chars < 1) {
			return false;
		}

		if (this.nr_of_digits < 1) {
			return false;
		}

		return true;
	}

	public String getPassword() {
		return this.password;
	}

	public String getCreatedFrom() {
		return this.created_from;
	}

	public int getNrOfSpecialChars() {
		return this.nr_of_special_chars;
	}

	public int getNrOfDigits() {
		return this.nr_of_digits;
	}
}