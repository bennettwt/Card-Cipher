/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

public class MS2Main {

	public static void main(String[] args) {
		KeyStream deck = new KeyStream(7);
		for(int i = 0; i < 1000; i++){
			System.out.println(deck.generateNextKey());
		}

	}

}
