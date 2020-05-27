package Game2048;

public class ver_5 {

	public static void main(String[] args) {
//gameover
		int[][] ar = { { 2, 4, 6, 8 }, { 1, 3, 5, 7 }, { 10, 12, 14, 16 }, { 11, 13, 15, 17 } };

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		int count = 0;
		int k = 0;
		LOOP1 : for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
					if (ar[i][j] != ar[i][k] && ar[j][i] != ar[k][j]) {
						System.out.println("i: "+i+" j: "+j+" k: "+k);
						count++;
						System.out.println(count);
						if(count==(ar.length*ar.length)){
							System.out.println("game over");
							break LOOP1;
						}
					}
				}
			}
		}

	}

