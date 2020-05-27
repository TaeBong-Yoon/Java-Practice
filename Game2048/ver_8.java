package Game2048;

import java.util.Scanner;
import java.util.Random;

public class ver_8 {
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int percentX;
	static int percentY;
	static int percent;
	static int N;
	static String command;
	static int[][] ar;
	static int[][] newar;
	static int count = 0;
	static int score = 0; // +=
	static int turn_count = 0;
	static int full_count = 0;

	static void map() {
//		제대로 game over 안되는이유 : count가 한박자 느림. : 입력받고 돌아와서 check하는데 추가는 그 이후에 됨.

		full_count = 0;
		System.out.println("map in");
		System.out.println("check your fucking map");
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				System.out.print(ar[i][j] + " ");
			}
			System.out.println();
		}

		
		System.out.println("count 1 " + full_count);
		if (full_count != N * N) {
			if (turn_count == 0) {
				for (int i = 0; i < 2; i++) {
					percentX = rand.nextInt(N);
					percentY = rand.nextInt(N);
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
				turn_count++;
			} else {
				while (true) {
					percentX = rand.nextInt(N);
					percentY = rand.nextInt(N);
					percent = rand.nextInt(100);
					if (ar[percentX][percentY] == 0) {
						if (percent >= 70) {
							ar[percentX][percentY] = 4;
						} else {
							ar[percentX][percentY] = 2;
						}
						break;
					} else {
						continue;
					}
				}
				turn_count++;
			}
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					System.out.print(ar[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("------------------");
			
			while (true) {
				System.out.println("input command");
				command = scan.next();
				if (command.equals("right") || command.equals("left") || command.equals("up")
						|| command.equals("down")) {
					add(command);
					System.out.println();
					System.out.println("first command");
					System.out.println();
					break;
				} else {
					System.out.println("## press key again ##");
					continue;
				}
			}
			for (int i = 0; i < ar.length; i++) {
				for (int j = 0; j < ar.length; j++) {
					if (ar[i][j] != 0) {
						full_count++;
					}
				}
			}
			if (full_count == N * N) {
				System.out.println("full in");
				for (int i = 0; i < ar.length; i++) {
					for (int j = 0; j < ar.length; j++) {
						System.out.print(ar[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("------------------");
				int k;
				for (int i = 0; i < ar.length; i++) {
					for (int j = 0; j < ar.length - 1; j++) {
						k = j + 1;
						if (ar[i][j] == ar[i][k]) {
							while (true) {
								command = scan.next();
								if (command.equals("right") || command.equals("left") || command.equals("up")
										|| command.equals("down")) {
									add(command);
									break;
								} else {
									System.out.println("## press key again ##");
									continue;
								}
							}
						}
					}
				}
				for (int i = 0; i < ar.length; i++) {
					for (int j = ar.length - 1; j > 0; j--) {
						k = j - 1;
						if (ar[i][j] == ar[i][k]) {
							while (true) {
								command = scan.next();
								if (command.equals("right") || command.equals("left") || command.equals("up")
										|| command.equals("down")) {
									add(command);
									break;
								} else {
									System.out.println("## press key again ##");
									continue;
								}
							}
						}
					}
				}
				for (int i = 0; i < ar.length; i++) {
					for (int j = ar.length - 1; j > 0; j--) {
						k = j - 1;
						if (ar[j][i] == ar[k][i]) {
							while (true) {
								command = scan.next();
								if (command.equals("right") || command.equals("left") || command.equals("up")
										|| command.equals("down")) {
									add(command);
									break;
								} else {
									System.out.println("## press key again ##");
									continue;
								}
							}
						}
					}
				}
				for (int i = 0; i < ar.length; i++) {
					for (int j = 0; j < ar.length - 1; j++) {
						k = j + 1;
						if (ar[j][i] == ar[k][i]) {
							while (true) {
								command = scan.next();
								if (command.equals("right") || command.equals("left") || command.equals("up")
										|| command.equals("down")) {
									add(command);
									break;
								} else {
									System.out.println("## press key again ##");
									continue;
								}
							}
						}
					}
				}
				System.out.println("full out");
				return;
			}
			map();
		}
	}

	static void add(String command) {
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
//		map();
	}

	public static void main(String[] args) {

		N = scan.nextInt();
		ar = new int[N][N];
		newar = new int[N][N];

		map();
		System.out.println("Game Over");

	}

}
