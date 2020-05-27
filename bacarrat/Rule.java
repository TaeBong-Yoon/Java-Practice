package bacarrat;

public class Rule {

	static int playerSum;
	static int bankerSum;
	static int playersThirdCard;
//	룰 구현
//	rule

// 	8,9 both stop
//	6,7 player stand - banker hits if 5 or less
//	5 or less - player hits

//	banker hits - picture

//	true면 hit
//	false면 stand

//	have to make
//	플레이어가 스탠드일때 뱅커가 hit,
//	플레이어가 힛일때 뱅커가 hit or stand

//	매개변수 sum = player sum , banker sum

//	true = hit
//	false = stand

	public static boolean ruleForPlayer(int sum) {
		playerSum = sum;
		if (playerSum == 6 || playerSum == 7) { // bankerSum <= 5 hit.
			return false;
		} else if (playerSum <= 5) { // player hit , banker hit
			return true;
		}

		return true;
	}
//	플레이어 stand의 경우
	public static boolean ruleForBanker(int sum) {
		bankerSum = sum;
		if ((playerSum == 6 || playerSum == 7) && (bankerSum <= 5)) { // player stand
			return true;
		} else if (bankerSum <= 2) {
			return true;
		}

		return false;
	}

//	플레이어가 3번째 카드를 받았을때의 조건
	public static boolean ruleForBankerIfPlayerDraw(int sum, int card) {
		playersThirdCard = card;
		bankerSum = sum;
		if (playersThirdCard == 9) {
			if (bankerSum <= 3) {
				return true;
			}
		} else if (playersThirdCard == 8) {
			if (bankerSum <= 2) {
				return true;
			}
		} else if (playersThirdCard == 7 || playersThirdCard == 6) {
			if (bankerSum <= 6) {
				return true;
			}
		} else if (playersThirdCard == 5 || playersThirdCard == 4) {
			if (bankerSum <= 5) {
				return true;
			}
		} else if (playersThirdCard == 3 || playersThirdCard == 2) {
			if (bankerSum <= 4) {
				return true;
			}
		} else if (playersThirdCard == 1 || playersThirdCard == 0) {
			if (bankerSum <= 3) {
				return true;
			}
		}
		return false;

	}

}
