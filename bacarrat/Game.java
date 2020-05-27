package bacarrat;

import java.util.Scanner;

public class Game {

	private static Card card;
	private static CardDeck cardDeck = new CardDeck();
	private static Scanner scan = new Scanner(System.in);
	private static String command;
	private static Bacarrat_Bet bb = new Bacarrat_Bet();

	private static String denomination;

	public static int[] player = new int[3];
	public static int[] banker = new int[3];

	private static String[] playerPairCheck;
	private static String[] bankerPairCheck;

	private static int playerThirdCard;

	public static void game() {

		while (true) {

			betting();
			System.out.println("Press s to Start");

			int playersum = 0;
			int bankersum = 0;
			command = scan.next();
			if (command.equals("s")) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						player[i] = 0;
						banker[i] = 0;
					}
				}

				playersum = playerDraw(false);
				bankersum = bankerDraw(false);

				if (playersum == 8 || playersum == 9 || bankersum == 8 || bankersum == 9) {
					whoIsWinner(playersum, bankersum);
					continue;
				} else {
					boolean playerdraw = Rule.ruleForPlayer(playersum);
					if (playerdraw == false) { // 플레이어 stand일때
						boolean bankerdrawbefore = Rule.ruleForBanker(bankersum);// 뱅커 hit여부
						if (bankerdrawbefore == true) { // 뱅커 hit
							bankersum = bankerDraw(true);
							whoIsWinner(playersum, bankersum);
							continue;
						}
					} else { // 플레이어 hit
						playersum = playerDraw(true); // 플레이어 3번째 카드
						boolean bankerdrawafter = Rule.ruleForBankerIfPlayerDraw(bankersum, playerThirdCard);
						if (bankerdrawafter == true) {// 뱅커 hit
							bankersum = bankerDraw(true);
							whoIsWinner(playersum, bankersum);
							continue;
						}
						whoIsWinner(playersum, bankersum);
						continue;
					}
				}

			} else {
				System.out.println("press key s");
				continue;
			}

		}
	}

	private static void betting() {
		System.out.println();
		
		System.out.println("               Where do you want to bet?             ");
		System.out.println("| Player Pair | Player | Tie | Banker | Banker Pair |");
		System.out.println("|    X 11     |   X1   |  X8 |  X1.95 |    X11      |");
		System.out.println("|     pp      |   p    |  t  |   b    |     bp      |");
		System.out.println("               If you done to bet, press d           ");
		System.out.println("           If you don't want to bet, press g         ");

		boolean samePlace = true;

		while (true) {
			String bet = scan.next();
			if (bet.equals("pp")) {
				bb.betPlayerPair();
			} else if (bet.equals("p")) {
				if (samePlace == true) {
					bb.betPlayer();
					samePlace = false;
				} else if (samePlace == false) {
					System.out.println("You arleady bet to Banker");
				}
			} else if (bet.equals("t")) {
				bb.betTie();
			} else if (bet.equals("b")) {
				if (samePlace == true) {
					bb.betBanker();
					samePlace = false;
				} else if (samePlace == false) {
					System.out.println("You arleady bet to Player");
				}
			} else if (bet.equals("bp")) {
				bb.betBankerPair();
			} else if (bet.equals("d")) {
				return;
			} else if (bet.equals("g")) {
				return;
			} else {
				System.out.println("Press Correctly");
				continue;
			}

		}

	}

// 	플레이어, 뱅커 드로우를 담당.
//	for draw card
	private static int playerDraw(boolean turn) {
		playerThirdCard = 0;
		int playersum = 0;
		playerPairCheck = new String[2];
		System.out.println("=======================================================");
		System.out.println("                      Player Turn                      ");
		System.out.println("=======================================================");
		if (turn == false) {
			for (int i = 0; i < 2; i++) {
				card = cardDeck.draw();
				System.out.println(card);
				denomination = card.getDenomination();
				playerPairCheck[i] = denomination;
				player[i] = changeDemoToNum(denomination);

			}
			playersum = addNumber("player", player);
			if (playerPairCheck[0]==playerPairCheck[1]) {
				System.out.println("Player Pair!");
				bb.PlayerPairWIn();
				bb.resetPlayerPairBet();
			}
			System.out.println();
			System.out.println("player sum : " + playersum);
			return playersum;
		} else {
			card = cardDeck.draw();
			System.out.println(card);
			denomination = card.getDenomination();

			player[2] = changeDemoToNum(denomination);
			playerThirdCard = player[2];
			playersum = addNumber("player", player);
			System.out.println();
			System.out.println("player sum : " + playersum);
			return playersum;
		}
	}

	private static int bankerDraw(boolean turn) {
		int bankersum = 0;
		bankerPairCheck = new String[2];
		System.out.println("=======================================================");
		System.out.println("                      Banker Turn                      ");
		System.out.println("=======================================================");
		if (turn == false) {
			for (int i = 0; i < 2; i++) {
				card = cardDeck.draw();
				System.out.println(card);
				denomination = card.getDenomination();
				bankerPairCheck[i] = denomination;
				banker[i] = changeDemoToNum(denomination);

			}
			bankersum = addNumber("banker", banker);
			if (bankerPairCheck[0]==bankerPairCheck[1]) {
				System.out.println("Banker Pair!");
				bb.bankerPairWIn();
				bb.resetBankerPairBet();
			}
			System.out.println();
			System.out.println("banker sum : " + bankersum);
			return bankersum;
		} else {
			card = cardDeck.draw();
			System.out.println(card);
			denomination = card.getDenomination();

			banker[2] = changeDemoToNum(denomination);
			bankersum = addNumber("banker", banker);
			System.out.println();
			System.out.println("banker sum : " + bankersum);
			return bankersum;
		}
	}

//	draw한 카드를 숫자로 변형해주는 메소드
//	change denomination(String to number)
	private static int changeDemoToNum(String denomination) {

		if (denomination.equals("A")) {
			return 1;
		} else if (denomination.equals("10")) {
			return 0;
		} else if (denomination.equals("J")) {
			return 0;
		} else if (denomination.equals("Q")) {
			return 0;
		} else if (denomination.equals("K")) {
			return 0;
		} else {
			return Integer.parseInt(denomination);
		}
	}

//	변환된 숫자를 더해서 sum을 리턴. 
	private static int addNumber(String who, int[] number) {
		int sum = 0;
		if (who.equals("player")) {
			for (int i = 0; i < number.length; i++) {
				sum += number[i];
			}
			return sum %= 10;

		} else if (who.equals("banker")) {
			for (int i = 0; i < number.length; i++) {
				sum += number[i];
			}
			return sum %= 10;
		}
		return 0;
	}

	private static void whoIsWinner(int play, int bank) {
		System.out.println("=======================================================");
		if (play > bank) {
			System.out.println("Player Win - player = " + play + " banker = " + bank);
			bb.playerWIn();
			bb.resetTieBet();
			bb.resetPlayerBet();
			bb.resetBankerBet();
		} else if (play < bank) {
			System.out.println("Banker Win - player = " + play + " banker = " + bank);
			bb.bankerWIn();
			bb.resetTieBet();
			bb.resetPlayerBet();
			bb.resetBankerBet();
		} else if (play == bank) {
			System.out.println("Tie - player = " + play + " banker = " + bank);
			bb.tieWin();
			bb.resetTieBet();
			bb.resetPlayerBet();
			bb.resetBankerBet();
		} else {
			System.out.println("error!");
		}
	}

	public static void main(String[] args) {
		System.out.println("========= Bacarrat =========");
		bb.setBalance();
		game();

	}

}
