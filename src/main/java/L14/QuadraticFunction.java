package L14;

public class QuadraticFunction {
	double a;
	double b;
	double c;
	double x;
	double allg;

	public QuadraticFunction(double a, double b, double c, double x) {
		if (a == 0) {
			throw new RuntimeException("a cannot be 0");
		}
		this.a = a;
		this.b = b;
		this.c = c;
		this.x = x;
		this.allg = a * x * x + b * x + c;
	}

	public static void main(String[] args) {
		QuadraticFunction test = new QuadraticFunction(1, 2, 3, 4);
		System.out.println(test.allg);
	}

	public double[] roots() {
		double root = Math.sqrt(Math.pow(this.b,2) - 4 * this.a * this.c);
		double x1 = ((-this.b) + root) / (2 * this.a);
		double x2 = ((-this.b) - root) / (2 * this.a);
		return new double[]{x1, x2};
	}
}
