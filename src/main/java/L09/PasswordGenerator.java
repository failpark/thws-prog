package L09;

public class PasswordGenerator {

	public static Password generatePasswordFromFirst(String sentence) {
		Password pwd = new Password(sentence);

		String cleaned = trim_spaces(sentence);
		String[] words = split_by_space(cleaned);

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (is_number_word(word)) {
				char first_char = word.charAt(0);
				pwd.addCharToPassword(first_char, false, true);
			} else {
				char first_char = word.charAt(0);
				boolean is_special = is_special_char(first_char);
				boolean is_digit = is_digit_char(first_char);
				pwd.addCharToPassword(first_char, is_special, is_digit);

				for (int j = 1; j < word.length(); j++) {
					char ch = word.charAt(j);
					if (is_special_char(ch)) {
						pwd.addCharToPassword(ch, true, false);
					}
				}
			}
		}

		return pwd;
	}

	public static Password generatePasswordFromLast(String sentence) {
		Password pwd = new Password(sentence);

		String cleaned = trim_spaces(sentence);
		String[] words = split_by_space(cleaned);

		boolean use_lowercase = true;

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (is_number_word(word)) {
				char last_char = word.charAt(word.length() - 1);
				pwd.addCharToPassword(last_char, false, true);
			} else {
				for (int j = 0; j < word.length() - 1; j++) {
					char ch = word.charAt(j);
					if (is_special_char(ch)) {
						pwd.addCharToPassword(ch, true, false);
					}
				}

				char last_char = word.charAt(word.length() - 1);

				if (is_special_char(last_char)) {
					pwd.addCharToPassword(last_char, true, false);
				} else {
					boolean is_digit = is_digit_char(last_char);

					if (use_lowercase) {
						pwd.addCharToPassword(to_lowercase(last_char), false, is_digit);
					} else {
						pwd.addCharToPassword(to_uppercase(last_char), false, is_digit);
					}
					use_lowercase = !use_lowercase;
				}
			}
		}

		return pwd;
	}

	private static String trim_spaces(String text) {
		int start = 0;
		while (start < text.length() && text.charAt(start) == ' ') {
			start++;
		}

		int end = text.length();
		while (end > 0 && text.charAt(end - 1) == ' ') {
			end--;
		}

		return text.substring(start, end);
	}

	private static String[] split_by_space(String text) {
		int word_count = 0;
		boolean in_word = false;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				in_word = false;
			} else {
				if (!in_word) {
					word_count++;
					in_word = true;
				}
			}
		}

		String[] words = new String[word_count];
		int word_index = 0;
		int start_pos = 0;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				if (i > start_pos) {
					words[word_index] = text.substring(start_pos, i);
					word_index++;
				}
				start_pos = i + 1;
			}
		}

		if (start_pos < text.length()) {
			words[word_index] = text.substring(start_pos);
		}

		return words;
	}

	private static boolean is_number_word(String word) {
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (ch < '0' || ch > '9') {
				return false;
			}
		}
		return word.length() > 0;
	}

	private static boolean is_special_char(char ch) {
		return ch == '!' || ch == '?' || ch == ':' || ch == '%';
	}

	private static boolean is_digit_char(char ch) {
		return ch >= '0' && ch <= '9';
	}

	private static char to_lowercase(char ch) {
		if (ch >= 'A' && ch <= 'Z') {
			return (char)(ch + 32);
		}
		return ch;
	}

	private static char to_uppercase(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return (char)(ch - 32);
		}
		return ch;
	}

	public static void main(String[] args) {
		String test1 = "Ich gehe morgen mit meinen 11 Freund*innen zum Essen!";
		System.out.println("Input: " + test1);
		Password pwd1_first = generatePasswordFromFirst(test1);
		System.out.println("First: " + pwd1_first.getPassword() + " (valid: " + pwd1_first.validate() + ", digits: " + pwd1_first.getNrOfDigits() + ", special: " + pwd1_first.getNrOfSpecialChars() + ")");
		Password pwd1_last = generatePasswordFromLast(test1);
		System.out.println("Last:  " + pwd1_last.getPassword() + " (valid: " + pwd1_last.validate() + ", digits: " + pwd1_last.getNrOfDigits() + ", special: " + pwd1_last.getNrOfSpecialChars() + ")");
		System.out.println();

		String test2 = "Fünf Fakultät oder auch 5! Ergibt 120.";
		System.out.println("Input: " + test2);
		Password pwd2_first = generatePasswordFromFirst(test2);
		System.out.println("First: " + pwd2_first.getPassword() + " (valid: " + pwd2_first.validate() + ", digits: " + pwd2_first.getNrOfDigits() + ", special: " + pwd2_first.getNrOfSpecialChars() + ")");
		Password pwd2_last = generatePasswordFromLast(test2);
		System.out.println("Last:  " + pwd2_last.getPassword() + " (valid: " + pwd2_last.validate() + ", digits: " + pwd2_last.getNrOfDigits() + ", special: " + pwd2_last.getNrOfSpecialChars() + ")");
		System.out.println();

		String test3 = "So wird das nichts!";
		System.out.println("Input: " + test3);
		Password pwd3_first = generatePasswordFromFirst(test3);
		System.out.println("First: " + pwd3_first.getPassword() + " (valid: " + pwd3_first.validate() + ", digits: " + pwd3_first.getNrOfDigits() + ", special: " + pwd3_first.getNrOfSpecialChars() + ")");
		Password pwd3_last = generatePasswordFromLast(test3);
		System.out.println("Last:  " + pwd3_last.getPassword() + " (valid: " + pwd3_last.validate() + ", digits: " + pwd3_last.getNrOfDigits() + ", special: " + pwd3_last.getNrOfSpecialChars() + ")");
		System.out.println();

		String test4 = "Hurr!a ich habe 90% der Aufgaben richtig gelöst.";
		System.out.println("Input: " + test4);
		Password pwd4_first = generatePasswordFromFirst(test4);
		System.out.println("First: " + pwd4_first.getPassword() + " (valid: " + pwd4_first.validate() + ", digits: " + pwd4_first.getNrOfDigits() + ", special: " + pwd4_first.getNrOfSpecialChars() + ")");
		Password pwd4_last = generatePasswordFromLast(test4);
		System.out.println("Last:  " + pwd4_last.getPassword() + " (valid: " + pwd4_last.validate() + ", digits: " + pwd4_last.getNrOfDigits() + ", special: " + pwd4_last.getNrOfSpecialChars() + ")");
		System.out.println();

		String test5 = "Wiederhole 3 mal: Das ! in Java ist der Negierungsoperator der booleschen Algebra.";
		System.out.println("Input: " + test5);
		Password pwd5_first = generatePasswordFromFirst(test5);
		System.out.println("First: " + pwd5_first.getPassword() + " (valid: " + pwd5_first.validate() + ", digits: " + pwd5_first.getNrOfDigits() + ", special: " + pwd5_first.getNrOfSpecialChars() + ")");
		Password pwd5_last = generatePasswordFromLast(test5);
		System.out.println("Last:  " + pwd5_last.getPassword() + " (valid: " + pwd5_last.validate() + ", digits: " + pwd5_last.getNrOfDigits() + ", special: " + pwd5_last.getNrOfSpecialChars() + ")");
		System.out.println();

		String test6 = "   Ich gehe morgen mit meinen 11 Freund*innen zum Essen!   ";
		System.out.println("Input: [" + test6 + "]");
		Password pwd6_first = generatePasswordFromFirst(test6);
		System.out.println("First: " + pwd6_first.getPassword() + " (valid: " + pwd6_first.validate() + ", digits: " + pwd6_first.getNrOfDigits() + ", special: " + pwd6_first.getNrOfSpecialChars() + ")");
		Password pwd6_last = generatePasswordFromLast(test6);
		System.out.println("Last:  " + pwd6_last.getPassword() + " (valid: " + pwd6_last.validate() + ", digits: " + pwd6_last.getNrOfDigits() + ", special: " + pwd6_last.getNrOfSpecialChars() + ")");
		System.out.println();

		String test7 = "Hurr!a ich    habe 90 % der Aufgaben richtig gelöst.";
		System.out.println("Input: " + test7);
		Password pwd7_first = generatePasswordFromFirst(test7);
		System.out.println("First: " + pwd7_first.getPassword() + " (valid: " + pwd7_first.validate() + ", digits: " + pwd7_first.getNrOfDigits() + ", special: " + pwd7_first.getNrOfSpecialChars() + ")");
		Password pwd7_last = generatePasswordFromLast(test7);
		System.out.println("Last:  " + pwd7_last.getPassword() + " (valid: " + pwd7_last.validate() + ", digits: " + pwd7_last.getNrOfDigits() + ", special: " + pwd7_last.getNrOfSpecialChars() + ")");
	}
}