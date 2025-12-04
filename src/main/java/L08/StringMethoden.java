package L08;

public class StringMethoden {

	public static String deleteStartingSpace(String sentence) {
		int start_index = 0;
		while (start_index < sentence.length() && sentence.charAt(start_index) == ' ') {
			start_index++;
		}
		return sentence.substring(start_index);
	}

	public static String deleteEndingSpace(String sentence) {
		int end_index = sentence.length();
		while (end_index > 0 && sentence.charAt(end_index - 1) == ' ') {
			end_index--;
		}
		return sentence.substring(0, end_index);
	}

	public static String deleteMultipleSpace(String sentence) {
		String result = "";
		boolean previous_was_space = false;

		for (int i = 0; i < sentence.length(); i++) {
			char current = sentence.charAt(i);

			if (current == ' ') {
				if (!previous_was_space) {
					result = result + current;
				}
				previous_was_space = true;
			} else {
				result = result + current;
				previous_was_space = false;
			}
		}

		return result;
	}

	public static String[] splitAtSpace(String input) {
		int word_count = count_words(input);
		String[] result = new String[word_count];

		int word_index = 0;
		int start_position = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				if (i > start_position) {
					result[word_index] = input.substring(start_position, i);
					word_index++;
				}
				start_position = i + 1;
			}
		}

		if (start_position < input.length()) {
			result[word_index] = input.substring(start_position);
		}

		return result;
	}

	private static int count_words(String input) {
		if (input.length() == 0) {
			return 0;
		}

		int count = 0;
		boolean in_word = false;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				in_word = false;
			} else {
				if (!in_word) {
					count++;
					in_word = true;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String test1 = "   Ich gehe morgen mit meinen 11 Freund*innen zum Essen!   ";

		System.out.println("Original: [" + test1 + "]");
		System.out.println("deleteStartingSpace: [" + deleteStartingSpace(test1) + "]");
		System.out.println("deleteEndingSpace: [" + deleteEndingSpace(test1) + "]");

		String test2 = "Ich  gehe   morgen  mit  meinen   11  Freund*innen  zum  Essen!";
		System.out.println("\nOriginal: [" + test2 + "]");
		System.out.println("deleteMultipleSpace: [" + deleteMultipleSpace(test2) + "]");

		String test3 = "Ich gehe morgen mit meinen 11 Freund*innen zum Essen!";
		System.out.println("\nOriginal: [" + test3 + "]");
		String[] words = splitAtSpace(test3);
		System.out.println("splitAtSpace:");
		for (int i = 0; i < words.length; i++) {
			System.out.println(i + ": " + words[i]);
		}
	}
}