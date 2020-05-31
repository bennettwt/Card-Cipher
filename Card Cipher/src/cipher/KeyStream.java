/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KeyStream {
	private java.util.Collection<Card> deck;
	private ULStack<Card> stackDeck;
	private ULQueue<Card> clubQ, diamondQ, heartQ, spadeQ;
	private int key;
	
	public KeyStream(long seed) {
		//creates a non-shuffled Arraylist deck of 52 cards
		ArrayList<Card> shuffledDeck = new ArrayList<Card>(52);
		Card.Rank[] ranks = Card.Rank.values();
		Card.Suit[] suits = Card.Suit.values();
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 13; j++) {
				Card card = new Card(ranks[j], suits[i]);
				shuffledDeck.add(card);
			}
		}
		
		//shuffles the deck with the given seed
		Random rnd = new Random();
		rnd.setSeed(seed);
		for(int i = 0; i < 7; i++) {
			Collections.shuffle(shuffledDeck, rnd);
		}
		
		// Transfers shuffled deck from Arraylist to a stack
		stackDeck = new ULStack<Card>();
		while(!shuffledDeck.isEmpty()) {
			stackDeck.push(shuffledDeck.get(shuffledDeck.size() - 1));
			shuffledDeck.remove(shuffledDeck.size() - 1);
		}
		
		Card card;
		clubQ = new ULQueue<Card>(13);
		heartQ = new ULQueue<Card>(13);
		diamondQ = new ULQueue<Card>(13);
		spadeQ = new ULQueue<Card>(13);
		
		// Transfers cards to 4 separate Queues, depending on Suit
		while(!stackDeck.empty()) {
			card = stackDeck.pop();
			switch(card.getSuit()) {
				case HEARTS :
					heartQ.push(card);
					break;
				case CLUB :
					clubQ.push(card);
					break;
				case DIAMOND :
					diamondQ.push(card);
					break;
				case SPADES :
					spadeQ.push(card);
					break;
				default :
					System.out.println("Incorrect Card Entered");
			}
		}
		
		// A key is generated based on the converted int value
		// of the top card of each of the four Queues
		key = ((heartQ.front().convertToInt()   +
					clubQ.front().convertToInt()     + 
					diamondQ.front().convertToInt()  +
					spadeQ.front().convertToInt()) - 10);
	}
	
	// Testing purposes only
	public KeyStream(java.util.Collection<Card> deck) {
		this.deck = deck;
	}
	
	// Returns the current key and then Generates next key
	public int generateNextKey() {
		ULStack<Card> discard = new ULStack<Card>();
		int currKey = key;
		
		// An explanation for this process can be found in assignment details
		clubQ.push(clubQ.pop());
		if(clubQ.front().getRank().getAbbreviation() == "A") {
			spadeQ.push(spadeQ.pop());
			if(spadeQ.front().getRank().getAbbreviation() == "A") {
				diamondQ.push(diamondQ.pop());
				if(diamondQ.front().getRank().getAbbreviation() == "A") {
					heartQ.push(heartQ.pop());
					while(spadeQ.front().getRank() != heartQ.front().getRank()) {
						discard.push(spadeQ.pop());
					}
					while(!discard.empty()) {
						spadeQ.push(discard.pop());
					}
				}
				while(clubQ.front().getRank() != diamondQ.front().getRank()) {
					discard.push(clubQ.pop());
				}
				while(!discard.empty()) {
					clubQ.push(discard.pop());
				}
			}
		}
		
		// Calculates the next key based on new top cards of each Queue
		// That value then becomes the next key that will be returned
		int nextKey = ((heartQ.front().convertToInt()   +
				clubQ.front().convertToInt()     + 
				diamondQ.front().convertToInt()  +
				spadeQ.front().convertToInt()) - 10);
		key = nextKey;
		return currKey;
		
	}
		
		
}


