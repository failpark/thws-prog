package L07;

public class Eratosthenes {
	public static void main(String[] args) {
		int n = 20;
		int[] zahlen = fillArray(20);
		sieve(zahlen);
		showContent(zahlen);
	}

	public static void showContent(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				System.out.println(i + 1 + " is not a prime number.");
			} else {
				System.out.println(i + 1 + " is a prime number.");
			}
		}
	}

	public static int[] fillArray(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		return arr;
	}

	public static int[] sieve(int[] arr) {
		for (int i = 0; i < (int)Math.sqrt(arr.length); i++) {
			if (arr[i] <= 1) {
				arr[i] = -1; // 1 ist keine Primzahl
			}
			if (arr[i] == -1) {
				continue;
			}
			for (int j = (arr[i] * arr[i]) - 1; j < arr.length; j = j + arr[i]) {
				arr[j] = -1;
			}
		}
		return arr;
	}
}
