package L07;

public class Maximum {
	public static void main(String[] args) {
		int[] array = {42, 3, 120, -57, 740, 13, 9, 230, 2};
		System.out.println(findMaximum(array));
	}

	public static int findMaximum(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
}
