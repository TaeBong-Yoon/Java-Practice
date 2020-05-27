package Game2048;

import java.util.Scanner;

public class ver_1 {
	static Scanner scan = new Scanner(System.in);
	static int[] ar = { 0, 2, 0, 0, 2, 0, 0, 0 };
	static int[] newar = new int[ar.length];
	static int count = 0;

	static String command;

	static void game() {
		while (true) {
			command = scan.nextLine();
			find(command);
			// reset ar
			for (int i = 0; i < ar.length; i++) {
				ar[i]=0;
			}
			for (int i = 0; i < ar.length; i++) {
				ar[i]=newar[i];
			}
			for (int i = 0; i < newar.length; i++) {
				newar[i]=0;
			}
			System.out.println("ar after reset");
			for (int i = 0; i < ar.length; i++) {
				System.out.print(ar[i] + " ");
			}
			System.out.println();
		}
	}

	static void find(String command) {
		System.out.println("check");
		for(int a : ar) {
			System.out.print(a+" ");
		}
		System.out.println();
		// right
		if (command.equals("right")) {
			for (int i = ar.length - 1; i >= 0; i--) {
				if (ar[i] != 0) {
					for (int j = i - 1; j >= 0; j--) {
						if (ar[j] != 0) {
							if (ar[i] == ar[j]) {
								ar[i] *= 2;
								ar[j] = 0;
							}
							break;
						}
					}
				}
			}
		}
		// left
		else if (command.equals("left")) {
			for (int i = 0; i < ar.length; i++) {
				if (ar[i] != 0) {
					for (int j = i + 1; j < ar.length; j++) {
						if (ar[j] != 0) {
							if (ar[i] == ar[j]) {
								ar[i] *= 2;
								ar[j] = 0;
							}
							break;
						}
					}
				}
			}
		}
		move(command);
		System.out.println("ar after move");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		System.out.println("newar after move");
		for (int i = 0; i < newar.length; i++) {
			System.out.print(newar[i] + " ");
		}
		System.out.println();

	}

	static void move(String command) {
		System.out.println("ar before move");
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		// right
		if (command.equals("right")) {
			for (int i = ar.length - 1; i >= 0; i--) {
				if (ar[i] != 0) {
					count++;
					newar[newar.length - count] = ar[i];
				}
			}
			count=0;
		}
		// left
		else if (command.equals("left")) {
			for (int i = 0; i < ar.length; i++) {
				if (ar[i] != 0) {
					count++;
					newar[count - 1] = ar[i];
				}
			}
		}
		count=0;
	}

	public static void main(String[] args) {

		game();

	}
}
