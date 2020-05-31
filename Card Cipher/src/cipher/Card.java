/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

public class Card {
	
	private Card.Suit suit;
	private Card.Rank rank;
	public static final int CARDS_PER_DECK = 52;
	public static final int CARDS_PER_SUIT = 13;
	
	// Testing purposes
	public Card() {
		rank = Rank.NO_RANK;
		suit = Suit.NO_SUIT;
	}
	
	// constructor
	public Card(Card.Rank aRank, Card.Suit aSuit) {
		rank = aRank;
		suit = aSuit;
	}
	
	public Card.Suit getSuit(){
		return suit;
	}
	
	public Card.Rank getRank(){
		return rank;
	}
	
	// Checks to see if cards are equal rank and suit
	public boolean equals(Object otherObject) {
		boolean sameObject = this == otherObject;
		boolean equal = false;
		if(!sameObject && otherObject != null && otherObject instanceof Card){
			if(this.getRank() == ((Card) otherObject).getRank() && this.getSuit() == ((Card) otherObject).getSuit()) {
				equal = true;
			}
		}
		return sameObject || equal;
	}
	
	// displays the abbreviated rank and suit of card
	public String toString() {
		return rank.getAbbreviation() + suit.getAbbreviation();
	}
	
	// Compares ranks of two cards
	public int compareRanks(Card otherCard) {
		return rank.compareTo(otherCard.rank);
	}
	
	// Converts the rank and suit into an int used to generate keys in keystream
	public int convertToInt() {
		return rank.ordinal() * suit.ordinal();
	}
	
	
	public static enum Rank{
		NO_RANK("NR"), ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), 
		NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");
		
		private String abbreviation;
		private Rank(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		
		public String getAbbreviation() {
			return abbreviation;
		}
		
	}

	public static enum Suit{
		NO_SUIT("NS"), HEARTS("H"), CLUB("C"), DIAMOND("D"), SPADES("S");
		
		private String abbreviation;
		private Suit(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		
		public String getAbbreviation() {
			return abbreviation;
		}
	}
}
