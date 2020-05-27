package Game2048;

public class ReturnArray_test {

	static int[] before;
	static int[] after;

	static int[] beforeMove(String co, int[] a) {

		int temp = a[0];
		if (co.equals("o")) {
			for (int i = 1; i < a.length - 1; i++) {
				if (temp < a[i]) {
					temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			System.out.println("section1");
			for (int ar : a) {
				System.out.print(ar + " ");
			}
			System.out.println();

			after = afterMove(co, a);

			System.out.println("section3");
			for (int ar : after) {
				System.out.print(ar + " ");
			}
			System.out.println();
		} else {
			System.out.println("NO");
		}

		return after;
	}

	static int[] afterMove(String co, int[] a) {

		if (co.equals("o")) {
			for (int i = 0; i < a.length; i++) {
				a[i] = 0;
			}
			System.out.println("section2");
			for (int ar : a) {
				System.out.print(ar + " ");
			}
			System.out.println();
		} else {
			System.out.println("no");
		}

		return a;
	}

	public static void main(String[] args) {

		before = new int[] { 1, 3, 2, 4, 5, 7, 6 };

		int[] afterMoving = beforeMove("x", before);

		System.out.println("section4");
		for (int i = 0; i < afterMoving.length; i++) {
			System.out.print(afterMoving[i] + " ");
		}
	}

}
