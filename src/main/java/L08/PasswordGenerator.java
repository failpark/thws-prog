package L08;

public class PasswordGenerator {

	public static String gen_password_from_first(String sentence) {
		String out = "";
		boolean is_start = true;
		boolean has_number = false;
		boolean has_special = false;
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			if (c == ' ') {
				is_start = true;
				continue;
			} else if (is_special_char(c)) {
				out += c;
				has_special = true;
			}
			if (is_start) {
				is_start = false;
				out += c;
				if ('0' <= c && c <= '9') {
					has_number = true;
				}
			}
		}
		if (has_number && has_special && out.length() <= 15 && out.length() >= 8) {
			return out;
		}
		return "Invalid";
	}

	public static String generatePasswordFromFirst(String sentence) {
		String cleaned = trim_spaces(sentence);
		String[] words = split_by_space(cleaned);

		String password = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (is_number_word(word)) {
				password = password + word.charAt(0);
			} else {
				password = password + word.charAt(0);

				for (int j = 1; j < word.length(); j++) {
					char ch = word.charAt(j);
					if (is_special_char(ch)) {
						password = password + ch;
					}
				}
			}
		}

		if (password.length() < 8 || password.length() > 15) {
			return "";
		}

		if (!has_special_char(password) || !has_digit(password)) {
			return "";
		}

		return password;
	}

	public static String generatePasswordFromLast(String sentence) {
		String cleaned = trim_spaces(sentence);
		String[] words = split_by_space(cleaned);

		String password = "";
		boolean use_lowercase = true;

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (is_number_word(word)) {
				password = password + word.charAt(word.length() - 1);
			} else {
				for (int j = 0; j < word.length() - 1; j++) {
					char ch = word.charAt(j);
					if (is_special_char(ch)) {
						password = password + ch;
					}
				}

				char last_char = word.charAt(word.length() - 1);

				if (is_special_char(last_char)) {
					password = password + last_char;
				} else {
					if (use_lowercase) {
						password = password + to_lowercase(last_char);
					} else {
						password = password + to_uppercase(last_char);
					}
					use_lowercase = !use_lowercase;
				}
			}
		}

		if (password.length() < 8 || password.length() > 15) {
			return "";
		}

		if (!has_special_char(password) || !has_digit(password)) {
			return "";
		}

		return password;
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

	private static boolean has_special_char(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (is_special_char(text.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	private static boolean has_digit(String text) {
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (ch >= '0' && ch <= '9') {
				return true;
			}
		}
		return false;
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
		System.out.println("First: " + generatePasswordFromFirst(test1));
		System.out.println("First (alternative): " + gen_password_from_first(test1));
		System.out.println("Last:  " + generatePasswordFromLast(test1));
		System.out.println();

		String test2 = "Fünf Fakultät oder auch 5! Ergibt 120.";
		System.out.println("Input: " + test2);
		System.out.println("First: " + generatePasswordFromFirst(test2));
		System.out.println("First (alternative): " + gen_password_from_first(test2));
		System.out.println("Last:  " + generatePasswordFromLast(test2));
		System.out.println();

		String test3 = "So wird das nichts!";
		System.out.println("Input: " + test3);
		System.out.println("First: " + generatePasswordFromFirst(test3));
		System.out.println("First (alternative): " + gen_password_from_first(test3));
		System.out.println("Last:  " + generatePasswordFromLast(test3));
		System.out.println();

		String test4 = "Hurr!a ich habe 90% der Aufgaben richtig gelöst.";
		System.out.println("Input: " + test4);
		System.out.println("First: " + generatePasswordFromFirst(test4));
		System.out.println("First (alternative): " + gen_password_from_first(test4));
		System.out.println("Last:  " + generatePasswordFromLast(test4));
		System.out.println();

		String test5 = "Wiederhole 3 mal: Das ! in Java ist der Negierungsoperator der booleschen Algebra.";
		System.out.println("Input: " + test5);
		System.out.println("First: " + generatePasswordFromFirst(test5));
		System.out.println("First (alternative): " + gen_password_from_first(test5));
		System.out.println("Last:  " + generatePasswordFromLast(test5));
		System.out.println();

		String test6 = "   Ich gehe morgen mit meinen 11 Freund*innen zum Essen!   ";
		System.out.println("Input: [" + test6 + "]");
		System.out.println("First: " + generatePasswordFromFirst(test6));
		System.out.println("First (alternative): " + gen_password_from_first(test6));
		System.out.println("Last:  " + generatePasswordFromLast(test6));
		System.out.println();

		String test7 = "Hurr!a ich    habe 90 % der Aufgaben richtig gelöst.";
		System.out.println("Input: " + test7);
		System.out.println("First: " + generatePasswordFromFirst(test7));
		System.out.println("First (alternative): " + gen_password_from_first(test7));
		System.out.println("Last:  " + generatePasswordFromLast(test7));
	}
}