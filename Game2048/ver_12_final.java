package Game2048;

import java.util.Scanner;
import java.util.Random;

public class ver_12_final {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int percentX;
	static int percentY;
	static int percent;
	static int persent = rand.nextInt(100);
	static int size;
	static int[][] ar;
	static int[][] newar;
	static int[][] compare;
	static int count = 0;
	static boolean bf;
	static int score = 0; // +=

	static void map() {

		for (int i = 0; i < 2; i++) {
			percentX = rand.nextInt(ar.length);
			percentY = rand.nextInt(ar.length);
			percent = rand.nextInt(100);
			if (ar[percentX][percentY] == 0) {
				if (percent >= 70) {
					ar[percentX][percentY] = 4;
				} else {
					ar[percentX][percentY] = 2;
				}
			} else {
				i--;
				continue;
			}
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				compare[i][j] = ar[i][j];
			}
		}
		System.out.println("Game start!");

		screen();

		for (int i = 0; i < 2; i++) {
			String command = scan.next();
			if (command.equals("right") || command.equals("left") || command.equals("down") || command.equals("up")) {
				find(command);
				boolean yesOrno = scanWhilePlay(ar);
				if (yesOrno == false) {
					System.out.println("### press key again!! ###");
					i--;
					continue;
				} else {
					break;
				}
			} else {
				System.out.println("### press key again!! ###");
				i--;
				continue;
			}
		}

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

			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					compare[i][j] = ar[i][j];
				}
			}

			bf = scanWhileFull(ar);
			if (bf == false) {
				screen();
				System.out.println("Game Over");
				return;
			}
			screen();
			while (true) {
				String command = scan.next();
				if (command.equals("right") || command.equals("left") || command.equals("down")
						|| command.equals("up")) {
					find(command);
					boolean yesOrno = scanWhilePlay(ar);
					if (yesOrno == false) {
						System.out.println("### press key again!! ###");
//						screen();
						continue;
					}
				} else {
					System.out.println("### press key again!! ###");
					continue;
				}

				break;
			}
		}

	}

	static void screen() {
		System.out.println("--------------");
		for (int i = 0; i < ar.length; i++) {
			for (int k = 0; k < ar.length; k++) {
				System.out.print(ar[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println("--------------");
	}

	static boolean scanWhilePlay(int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (compare[i][j] != a[i][j]) {

					return true;
				}
			}
		}
		return false;
	}

	static boolean scanWhileFull(int[][] a) {
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
//        right
		if (command.equals("right")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length - 1; j >= 0; j--) {
					if (ar[i][j] != 0) {
						for (int k = j - 1; k >= 0; k--) {
							if (ar[i][k] != 0) {
								if (ar[i][j] == ar[i][k]) {
									ar[i][j] *= 2;
									ar[i][k] = 0;
									score += ar[i][j];
								}
								break;
							}
						}
					}

				}
			}
		}
//       left
		else if (command.equals("left")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[i][j] != 0) {
						for (int k = j + 1; k < ar.length; k++) {
							if (ar[i][k] != 0) {
								if (ar[i][j] == ar[i][k]) {
									ar[i][j] *= 2;
									ar[i][k] = 0;
									score += ar[i][j];
								}
								break;
							}
						}
					}
				}
			}
		}
//       up
		else if (command.equals("up")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[j][i] != 0) {
						for (int k = j + 1; k < ar.length; k++) {
							if (ar[k][i] != 0) {
								if (ar[j][i] == ar[k][i]) {
									ar[j][i] *= 2;
									ar[k][i] = 0;
									score += ar[j][i];
								}
								break;
							}
						}
					}
				}
			}
		}
//       down
		else if (command.equals("down")) {
			for (int i = 0; i < ar.length; i++) {
				for (int j = ar.length - 1; j >= 0; j--) {
					if (ar[j][i] != 0) {
						for (int k = j - 1; k >= 0; k--) {
							if (ar[k][i] != 0) {
								if (ar[j][i] == ar[k][i]) {
									ar[j][i] *= 2;
									ar[k][i] = 0;
									score += ar[j][i];
								}
								break;
							}
						}
					}
				}
			}
		}
		System.out.println("SCORE : "+score);
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

		while (true) {
			System.out.println("========WELCOME TO GAME 2048========");
			System.out.println("Choose the size - 3 , 4 , 5 , 6 , 8");
			size = scan.nextInt();
			ar = new int[size][size];
			newar = new int[size][size];
			compare = new int[size][size];
			if (size == 3 || size == 4 || size == 5 || size == 6 || size == 8) {
				map();
				System.out.println("Your SCORE : "+score);
				break;
			} else {
				System.out.println("Size must be 3 , 4 , 5 , 6 , 8");
				continue;
			}
		}

	}

}