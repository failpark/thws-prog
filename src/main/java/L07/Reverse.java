package L07;

public class Reverse {
	public static void main(String[] args) {
		String test = "Übung Programmieren I";
		System.out.println(
				test +
				" -> " +
				reverse(test)
		);
	}

	public static String reverse(String input) {
		String out = "";
		char[] in = input.toCharArray();
		for (int i = (in.length - 1); 0 <= i; i--) {
			out += in[i];
		}
		return out;
	}
}
