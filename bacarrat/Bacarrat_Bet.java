package bacarrat;

import java.util.Scanner;

public class Bacarrat_Bet {

	private double balance;
	private double playerbet;
	private double bankerbet;
	private double tiebet;
	private double playerpairbet;
	private double bankerpairbet;
	private Scanner scan = new Scanner(System.in);

	protected void resetPlayerBet() {
		playerbet = 0;
	}

	protected void resetBankerBet() {
		bankerbet = 0;
	}

	protected void resetPlayerPairBet() {
		playerpairbet = 0;
	}

	protected void resetBankerPairBet() {
		bankerpairbet = 0;
	}

	protected void resetTieBet() {
		tiebet = 0;
	}

	protected void setBalance() {
		System.out.println("Set Your Balance");
		balance = scan.nextInt();
		System.out.println("Balance : " + balance);
	}

	protected void betPlayer() {
		while (true) {
			System.out.println("Set Betting Money");
			playerbet = scan.nextInt();
			balance -= playerbet;
			if (balance < 0) {
				System.out.println("Out of Balance. Setting Money Again");
				balance += playerbet;
				continue;
			}
			break;
		}
		System.out.println("Bet Player : " + playerbet);
		System.out.println("Balance : " + balance);
	}

	protected void betBanker() {
		while (true) {
			System.out.println("Set Betting Money");
			bankerbet = scan.nextInt();
			balance -= bankerbet;
			if (balance < 0) {
				System.out.println("Out of Balance. Setting Money Again");
				balance += bankerbet;
				continue;
			}
			break;
		}
		System.out.println("Bet Banker : " + bankerbet);
		System.out.println("Balance : " + balance);
	}

	protected void betTie() {
		while (true) {
			System.out.println("Set Betting Money");
			tiebet = scan.nextInt();
			balance -= tiebet;
			if (balance < 0) {
				System.out.println("Out of Balance. Setting Money Again");
				balance += tiebet;
				continue;
			}
			break;
		}
		System.out.println("Bet Tie : " + tiebet);
		System.out.println("Balance : " + balance);
	}

	protected void betPlayerPair() {
		while (true) {
			System.out.println("Set Betting Money");
			playerpairbet = scan.nextInt();
			balance -= playerpairbet;
			if (balance < 0) {
				System.out.println("Out of Balance. Setting Money Again");
				balance += playerpairbet;
				continue;
			}
			break;
		}
		System.out.println("Bet Player Pair : " + playerpairbet);
		System.out.println("Balance : " + balance);
	}

	protected void betBankerPair() {
		while (true) {
			System.out.println("Set Betting Money");
			bankerpairbet = scan.nextInt();
			balance -= bankerpairbet;
			if (balance < 0) {
				System.out.println("Out of Balance. Setting Money Again");
				balance += bankerpairbet;
				continue;
			}
			break;
		}
		System.out.println("Bet Banker pair : " + bankerpairbet);
		System.out.println("Balance : " + balance);
	}

	protected void playerWIn() {
		balance += playerbet * 2;
		System.out.println("You won :" + playerbet * 2);
		System.out.println("Balance : " + balance);
		System.out.println("=======================================================");
	}

	protected void bankerWIn() {
		balance += bankerbet * 1.95;
		System.out.println("You won :" + bankerbet * 1.95);
		System.out.println("Balance : " + balance);
		System.out.println("=======================================================");
	}

	protected void tieWin() {
		balance += playerbet;
		balance += bankerbet;
		balance += tiebet * 9;
		System.out.println("You won :" + tiebet * 9);
		System.out.println("Balance : " + balance);
		System.out.println("=======================================================");
	}

	protected void PlayerPairWIn() {
		balance += playerpairbet * 12;
		System.out.println("Player Pair :" + playerpairbet * 12);
		System.out.println("Balance : " + balance);
		System.out.println("=======================================================");
	}

	protected void bankerPairWIn() {
		balance += bankerpairbet * 12;
		System.out.println("Banker Pair :" + bankerpairbet * 12);
		System.out.println("Balance : " + balance);
		System.out.println("=======================================================");
	}

}
