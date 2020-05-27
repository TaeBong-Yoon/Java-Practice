package bacarrat;

public class ruleMemo {
	static int playerSum;
	static int bankerSum;
	static int playersThirdCard;

	static boolean rule() {

		
		
		
//		플레이어가 3번째 카드를 받았을때의 조건
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
			if(bankerSum <= 4) {
				return true;
			}
		} else if(playersThirdCard == 1||playersThirdCard == 0) {
			if(bankerSum<=3) {
				return true;
			}
		} else {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
	}

}
