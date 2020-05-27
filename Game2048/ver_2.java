package Game2048;

import java.util.Scanner;

public class ver_2 {
	static Scanner scan = new Scanner(System.in);
	static int[] ar = { 0, 2, 0, 0, 2 };
	static int[] newar = new int[5];
	static int count = 0;
	
	static String command = scan.nextLine();

	static void find() {
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
		move();
	}
//solution1 - not work
//		count++;
//		System.out.println("count:" + count);
//		System.out.println("start:" + (newar.length - count));
//		System.arraycopy(ar, 0, newar, newar.length - count-1, count+1);
//
//		System.out.println("전");
//		for (int i = 0; i < ar.length; i++) {
//			System.out.print(ar[i] + " ");
//		}
//		System.out.println();
//		System.out.println("-----------------");

//solution2 - not work
//		for (int i = 0; i < ar.length; i++) {
//			if(ar[i]!=0) {
//				count++;
//				for (int j = newar.length-1; j >= newar.length-count ; j--) {
//					newar[j]=ar[i];
//					
//				}
//			}
//		}

//solution3 - work! put in move()
//		for (int i = ar.length-1 ; i >= 0; i--) {
//			if(ar[i]!=0) {
//				count++;
//				newar[ar.length-count]=ar[i];
//			}
//		}
//	}

	static void move() {
		// right
		if (command.equals("right")) {
			for (int i = ar.length - 1; i >= 0; i--) {
				if (ar[i] != 0) {
					count++;
					newar[ar.length - count] = ar[i];
				}
			}
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
	}

	public static void main(String[] args) {

		find();

		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < newar.length; i++) {
			System.out.print(newar[i] + " ");
		}

	}
}
