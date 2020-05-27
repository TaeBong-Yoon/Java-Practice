package bacarrat;

import java.util.Random;

public class baccarat_test2 {
	static Random rand = new Random();
//	a = 1 , 10,j,q,k = 0
//	deck = 13 * 4
//	use 6 ~ 8 deck in game;
	static String[] deck = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	static int[] deckTonum = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0 };
	static int choose;
	static int[] player = new int[3];
	static int[] banker = new int[3];
	static int batting;
	static int playerSum;
	static int bankerSum;

	static void makeDeck() {

//		player turn
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < deck.length; j++) {
				if (deck[j].equals("A")) {
					player[i] = 1;
				} else if (deck[j].equals("2")) {
					player[i] = 2;
				} else if (deck[j].equals("3")) {
					player[i] = 3;
				} else if (deck[j].equals("4")) {
					player[i] = 4;
				} else if (deck[j].equals("5")) {
					player[i] = 5;
				} else if (deck[j].equals("6")) {
					player[i] = 6;
				} else if (deck[j].equals("7")) {
					player[i] = 7;
				} else if (deck[j].equals("8")) {
					player[i] = 8;
				} else if (deck[j].equals("9")) {
					player[i] = 9;
				} else {
					player[i] = 0;
				}
			}
		}

//		banker turn
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < deck.length; j++) {
				if (deck[j].equals("A")) {
					banker[i] = 1;
				} else if (deck[j].equals("2")) {
					banker[i] = 2;
				} else if (deck[j].equals("3")) {
					banker[i] = 3;
				} else if (deck[j].equals("4")) {
					banker[i] = 4;
				} else if (deck[j].equals("5")) {
					banker[i] = 5;
				} else if (deck[j].equals("6")) {
					banker[i] = 6;
				} else if (deck[j].equals("7")) {
					banker[i] = 7;
				} else if (deck[j].equals("8")) {
					banker[i] = 8;
				} else if (deck[j].equals("9")) {
					banker[i] = 9;
				} else {
					banker[i] = 0;
				}
			}
		}
		for (int i = 0; i < player.length; i++) {
			player[i] = 0;
		}
		for (int i = 0; i < banker.length; i++) {
			banker[i] = 0;
		}
	}

	static void baccarat() {

		playerSum = 0;
		bankerSum = 0;

		for (int i = 0; i < player.length; i++) {
			choose = rand.nextInt(deck.length);
			System.out.println(deck[choose]);
			player[i] = deckTonum[choose];
			playerSum += player[i];
		}
		playerSum %= 10;
		System.out.println("player sum : " + playerSum);

		for (int i = 0; i < banker.length; i++) {
			choose = rand.nextInt(deck.length);
			System.out.println(deck[choose]);
			banker[i] = deckTonum[choose];
			bankerSum += banker[i];
		}
		bankerSum %= 10;
		System.out.println("banker sum : " + bankerSum);

		if (playerSum == bankerSum) {
			System.out.println("Tie");
		} else if (playerSum > bankerSum) {
			System.out.println("Player Win");
		} else if (playerSum < bankerSum) {
			System.out.println("Banker Win");
		}

	}

	public static void main(String[] args) {

		baccarat();

	}

}