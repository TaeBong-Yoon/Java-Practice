package Game2048;

import java.util.Scanner;
import java.util.Random;

public class ver_6_testing {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int percentX;
	static int percentY;
	static int percent;
	static int persent = rand.nextInt(100);
	static int N = scan.nextInt();;
	static int[][] ar = new int[N][N];
	static int[][] newar = new int[N][N];
	static int count = 0;
	static int score = 0; // +=

	static void map() {
		
		System.out.println("choose the size");
		
		percentX = rand.nextInt(ar.length);
		percentY = rand.nextInt(ar.length);
		ar[percentX][percentY] = 2;
		percentX = rand.nextInt(ar.length);
		percentY = rand.nextInt(ar.length);
		ar[percentX][percentY] = 2;
		
		System.out.println("Game start!");
		for (int i = 0; i < ar.length; i++) {
			for (int k = 0; k < ar.length; k++) {
				System.out.print(ar[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println("------------");

		while (true) {
			String command = scan.nextLine();
			if (command.equals("right") || command.equals("left") || command.equals("down") || command.equals("up")) {
				game(command);
			} else {
				System.out.println("### press key again!! ###");
				continue;
			}

		}
	}

	static void game(String command) {
		//have to make game over
		
		
		find(command);
		// add 2 or 4
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
					System.out.print(ar[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("------------");
			break;
		}
	}

	static void find(String command) {
//		if(command.equals("right")) {
//			for (int i = 0; i < ar.length; i++) {
//				for (int j = 0; j < ar.length; j++) {
//					
//				}
//			}
//		}
		
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
