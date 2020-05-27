package Game2048;

public class Moving_oneline_test {

	public static void main(String[] args) {
		int count = 0;
		int[][] ar = { { 2, 0, 2 }, { 0, 0, 2 }, { 0, 0, 2 } };

		for (int i = 0; i < ar.length; i++) {
			for (int j = ar.length - 1; j >= 0; j--) {
				if (ar[i][j] != 0) {
					for (int k = j - 1; k >= 0; k--) {
						if (ar[i][k] != 0) {
							if (ar[i][j] == ar[i][k]) {
								ar[i][j] *= 2;
								ar[i][k] = 0;
							}
							break;
						}

					}
				} else {
					System.out.println("0:" +i+","+j);
				}

			}
		}
		int[][] newar = new int[ar.length][ar.length];
		// right
		for (int i = 0; i < ar.length; i++) {
			for (int j = ar.length - 1; j >= 0; j--) {
				if (ar[i][j] != 0) {
					count++;
					newar[i][ar.length - count] = ar[i][j];
				}
			}
			count = 0;
		}
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[i][j] = 0;
			}
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				ar[i][j] = newar[i][j];
			}
		}
		for (int i = 0; i < newar.length; i++) {
			for (int j = 0; j < newar.length; j++) {
				newar[i][j] = 0;
			}
		}

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
	}

}
