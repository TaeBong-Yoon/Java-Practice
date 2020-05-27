package bacarrat;

public class Card {
//	패턴
	private String pattern;
//	끝수
	private String denomination;
	
	public Card(String pattern, String denomination) {
		this.pattern = pattern;
		this.denomination = denomination;
	}

	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public String getDenomination() {
		return denomination;
	}
	
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
//	카드 리스트 출력
	@Override
	public String toString() {
		return "Card {" + " Pattern : " + pattern + " , denomination : " + denomination + " }";
	}
	
}
