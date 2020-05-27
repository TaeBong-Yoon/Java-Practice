package Game2048;

public class NoMove_test {

	static boolean move(String co, int[][] ar) {
		int k;
		if (co.equals("right")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length - 1; j++) {
					k = j + 1;
					if (ar[i][j] != 0 && ar[i][j + 1] == 0) {
						if(ar[i][j] == ar[i][k]);
						System.out.println("땡!" + i + " " + j);
						return true;
					}
				}

			}
		}
		if (co.equals("left")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length - 1 ; j > 0; j--) {
					if (ar[i][j] != 0 && ar[i][j - 1] == 0) {
						System.out.println("땡!" + i + " " + j);
						return true;
					}
				}

			}
		}
		if (co.equals("up")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length-1; j > 0 ; j--) {
					if (ar[j][i] != 0 && ar[j][i - 1] == 0) {
						System.out.println("땡!" + i + " " + j);
						return true;
					}
				}

			}
		}
		if (co.equals("down")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length - 1; j++) {
					if (ar[j][i] != 0 && ar[j][i + 1] == 0) {
						System.out.println("땡!" + i + " " + j);
						return true;
					}
				}

			}
		}
		return false;
	}

	public static void main(String[] args) {

		int[][] ar = { { 2, 0, 2 }, { 0, 2, 0 }, { 0, 0, 2 } };

		boolean a = move("up", ar);

		System.out.println(a);

	}

}
