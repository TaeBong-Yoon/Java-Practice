package bacarrat;

import java.util.Random;

public class baccarat_test3 {
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
		System.out.println("player sum : "+playerSum);
		
		for (int i = 0; i < banker.length; i++) {
			choose = rand.nextInt(deck.length);
			System.out.println(deck[choose]);
			banker[i] = deckTonum[choose];
			bankerSum += banker[i];
		}
		bankerSum %= 10;
		System.out.println("banker sum : "+bankerSum);
		
		if(playerSum == bankerSum) {
			System.out.println("Tie");
		} else if(playerSum > bankerSum) {
			System.out.println("Player Win");
		} else if(playerSum < bankerSum) {
			System.out.println("Banker Win");
		}
		
	}

	public static void main(String[] args) {

		baccarat();

	}

}