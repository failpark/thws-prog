package L05;

public class Loops {
	public static void main(String[] args) {
		a();
		b();
		c();
		d();
	}

	public static void a() {
		int i = 0;
		String str = "";
		while (true) {
			str += "* ";
			i++;
			if (i == 10) {
				break;
			}
		}
		System.out.println(str);
	}

	public static void b() {
		String str = "";
		for (int i = 0; i < 10; i++) {
			str += "* ";
		}
		System.out.println(str);
	}

	public static void c() {
		for (int k = 0; k < 10; k++) {
			if (k%2 == 0) {
				continue;
			}
			System.out.println(k);
		}
	}

	public static void d() {
		for (int i = 1; i < 10; i += 2) {
			System.out.println(i);
		}
	}
}
