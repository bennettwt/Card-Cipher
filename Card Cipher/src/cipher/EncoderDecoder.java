/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

public abstract class EncoderDecoder {

	
	public static char encode(char letter, int key) {
		return (char) ((key + letter) % 128);
	}
	
	
	public static char decode(char letter, int key) {
		int decodedChar = letter;
		// adds 128 to the given letter until it is larger than the key
		while(decodedChar < key) {
			decodedChar += 128;			
		}
		return (char) (decodedChar - key);
	}
}
