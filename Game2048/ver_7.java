package Game2048;

import java.util.Scanner;
import java.util.Random;

public class ver_7 {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int percentX;
	static int percentY;
	static int percent;
	static int persent = rand.nextInt(100);
	static int size = scan.nextInt();
	static int[][] ar = new int[size][size];
	static int[][] newar = new int[size][size];
	static int count = 0;
	static boolean bf;
	static int score = 0; // +=

	static void map() {

		percentX = rand.nextInt(ar.length);
		percentY = rand.nextInt(ar.length);
		ar[percentX][percentY] = 2;
		percentX = rand.nextInt(ar.length);
		percentY = rand.nextInt(ar.length);
		ar[percentX][percentY] = 2;

		System.out.println("Game start!");

		screen();

		String command = scan.next();
		for (int i = 0; i < 1; i++) {
			if (command.equals("right") || command.equals("left") || command.equals("down") || command.equals("up")) {
				find(command);
			} else {
				System.out.println("### press key again!! ###");
				i--;
				continue;
			}
		}

		while (true) {

			while (true) {
				percentX = rand.nextInt(ar.length);
				percentY = rand.nextInt(ar.length);
				if (ar[percentX][percentY] != 0) {
					continue;
				} else {
					percent = rand.nextInt(100);
					if (percent >= 70) {
						ar[percentX][percentY] = 4;
					} else {
						ar[percentX][percentY] = 2;
					}
				}

				break;
			}
			screen();
			bf = scan(ar);
			if (bf == false) {
				System.out.println("Game Over");
				break;
			}

			command = scan.next();
			if (command.equals("right") || command.equals("left") || command.equals("down") || command.equals("up")) {
				find(command);
			} else {
				System.out.println("### press key again!! ###");
				continue;
			}
		}

	}

	static void screen() {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}

	// 이슈 - 노트 problem 참조
	static boolean scan(int[][] a) {
		// false = game over, true = keep going
		int fill_count = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[i][j] != 0) {
					fill_count++;
				}
			}
		}
		// is there any same number?
		LOOP1: if (fill_count == a.length * a.length) {
			int k;
			// right
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - 1; j++) {
					k = j + 1;
					if (a[i][j] != a[i][k]) {
					} else {
						break LOOP1;
					}
				}
			}
			// left
			for (int i = 0; i < a.length; i++) {
				for (int j = a.length - 1; j > 0; j--) {
					k = j - 1;
					if (a[i][j] != a[i][k]) {
					} else {
						break LOOP1;
					}
				}
			}
			// up
			for (int i = 0; i < a.length; i++) {
				for (int j = a.length - 1; j > 0; j--) {
					k = j - 1;
					if (a[j][i] != a[k][i]) {
					} else {
						break LOOP1;
					}
				}
			}
			// down
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - 1; j++) {
					k = j + 1;
					if (a[j][i] != a[k][i]) {
					} else {
						break LOOP1;
					}
				}
			}
			return false;
		}
		return true;
	}

	static void find(String command) {
// 		 right
		if (command.equals("right")) {
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
					}

				}
			}
		}
//		 left
		else if (command.equals("left")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[i][j] != 0) {
						for (int k = j + 1; k < ar.length; k++) {
							if (ar[i][k] != 0) {
								if (ar[i][j] == ar[i][k]) {
									ar[i][j] *= 2;
									ar[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
//		 up
		else if (command.equals("up")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[j][i] != 0) {
						for (int k = j + 1; k < ar.length; k++) {
							if (ar[k][i] != 0) {
								if (ar[j][i] == ar[k][i]) {
									ar[j][i] *= 2;
									ar[k][i] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
//		 down
		else if (command.equals("down")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length - 1; j >= 0; j--) {
					if (ar[j][i] != 0) {
						for (int k = j - 1; k >= 0; k--) {
							if (ar[k][i] != 0) {
								if (ar[j][i] == ar[k][i]) {
									ar[j][i] *= 2;
									ar[k][i] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
		move(command);
	}

	static void move(String command) {
		// right
		if (command.equals("right")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length - 1; j >= 0; j--) {
					if (ar[i][j] != 0) {
						count++;
						newar[i][ar.length - count] = ar[i][j];
					}
				}
				count = 0;
			}
		}
		// left
		else if (command.equals("left")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[i][j] != 0) {
						count++;
						newar[i][count - 1] = ar[i][j];
					}
				}
				count = 0;
			}
		}
		// up
		else if (command.equals("up")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[j][i] != 0) {
						count++;
						newar[count - 1][i] = ar[j][i];
					}
				}
				count = 0;
			}
		}
		// down
		else if (command.equals("down")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length - 1; j >= 0; j--) {
					if (ar[j][i] != 0) {
						count++;
						newar[ar.length - count][i] = ar[j][i];
					}
				}
				count = 0;
			}
		}
		// reset
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
	}

	public static void main(String[] args) {

		map();

	}

}
