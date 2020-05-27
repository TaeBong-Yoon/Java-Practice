package bacarrat;

import java.util.HashMap;
import java.util.ArrayList;

public class hashMap {

	public static void main(String[] args) {
		//java 11
		var deck = new HashMap<String,Integer>();
		//java 8
//		import java.util.Map;
//		Map<String,Integer> deck = new HashMap<>();
		
		//input
		deck.put("A",1); deck.put("2",2); deck.put("3",3); deck.put("4",4); deck.put("5",5);
		deck.put("6",6); deck.put("7",7); deck.put("8",8); deck.put("9",9); deck.put("10",0);
		deck.put("J",0); deck.put("Q",0); deck.put("K",0);
		
		ArrayList<HashMap> game = new ArrayList<HashMap>();
		
		game.add(deck);
		game.add(deck);
		game.add(deck);
		game.add(deck);
		
		System.out.println(deck.size());
		System.out.println(game.size());
		
	}

}
