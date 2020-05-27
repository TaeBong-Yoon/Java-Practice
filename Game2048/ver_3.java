package Game2048;

import java.util.Scanner;

public class ver_3 {
	static Scanner scan = new Scanner(System.in);

	static int[][] ar = { { 2, 0, 2, 0, 2 }, { 2, 0, 2, 0, 2 }, { 2, 0, 2, 0, 2 }, { 2, 0, 2, 0, 2 },
			{ 2, 0, 2, 0, 2 } };
	static int[][] newar = new int[5][5];
	static int count = 0;

	static void game() {
		while (true) {
			String command = scan.nextLine();
			find(command);
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					System.out.print(ar[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("------------");
		}
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

		game();

	}

}
