/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import cipher.Card;


public class MS1Main {

	public static void main(String[] args) {
		ULStack<Card> deck = new ULStack<Card>();
		ArrayList<Card> deckS = new ArrayList<Card>(52);
		Card.Rank[] ranks = Card.Rank.values();
		Card.Suit[] suits = Card.Suit.values();
		for(int i = 4; i >= 1; i--) {
			for(int j = 13; j >= 1; j--) {
				Card card = new Card(ranks[j], suits[i]);
				deck.push(card);
			}
		}
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 13; j++) {
				Card card = new Card(ranks[j], suits[i]);
				deckS.add(card);
			}
		}
		while(!deck.empty()) {
			System.out.println(deck.pop().toString());
			
		}
		
		Random rnd = new Random();
		rnd.setSeed(7);
		for(int i = 0; i < 7; i++) {
			Collections.shuffle(deckS, rnd);
		}
		while(!deckS.isEmpty()) {
			System.out.println(deckS.get(0).toString());
			deckS.remove(0);
		}

	}

}
