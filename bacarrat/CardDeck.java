package bacarrat;

import java.util.LinkedList;
import java.util.List;

public class CardDeck {
//	중요! - 각 메소드는 하나의 역할만 수행하도록 한다.

	private List<Card> cards;

	public Card getCard() {
		return null;
	}

	private static final String[] PATTERNS = { "Spade", "Heart", "Diamond", "Clover" };
	private static final int CARD_COUNT = 13;

	public CardDeck() {
		cards = this.generateCards();
	}

//	카드 리스트를 생성해주는 메소드
	private List<Card> generateCards() {
		List<Card> cards = new LinkedList<>();

		for (int j = 1; j <= 8; j++) {
			for (String pattern : PATTERNS) {
				for (int i = 1; i <= CARD_COUNT; i++) {
//				카드 정보를 numberToDenomination 메소드에 보내고 받아옴.
					String denomination = this.numberToDenomination(i);
//				pattern, denomination 정보를 Card class로 보내고 받아옴.
					Card card = new Card(pattern, denomination);

					cards.add(card);

				}
			}
		}
		return cards;

	}

//	1~13 number 통해 끗자리 수를 정하는 메소드
	private String numberToDenomination(int number) {
		if (number == 1) {
			return "A";
		} else if (number == 11) {
			return "J";
		} else if (number == 12) {
			return "Q";
		} else if (number == 13) {
			return "K";
		} else {
			return String.valueOf(number);
		}
	}

//	카드를 뽑아주는 메소드
	public Card draw() {
		Card selectedCard = getRandomCard();
		cards.remove(selectedCard);
		return selectedCard;
	}

//	뽑은 카드를 삭제해주는 메소드
	private Card getRandomCard() {
		int size = cards.size();
		int select = (int) (Math.random() * size);
		return cards.get(select);
	}

//	카드 리스트 출력
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
//		append = 문자열을 붙여주는 역할을 한다. + 연산자처럼.
		for (Card card : cards) {
			sb.append(card.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}
