/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class Encoder extends EncoderDecoder {
	
	public static void main(String[] args) throws IOException {
		try {
			// Checks that 3 args are provided
			// breaks down a text documents into a string
			ULQueue<Character> q = new ULQueue<Character>();
			KeyStream keyS = new KeyStream(Integer.parseInt(args[0]));
			String content = new String(Files.readAllBytes(Paths.get(args[1])));
			FileWriter writer = new FileWriter(args[2]);
			// The string is then broken down into characters and put in a queue
			// The chars are also checked to make sure they fall between ASCII values
			for(int i = 0; i < content.length(); i++) {
					char code = content.charAt(i);
					if(code < 0 || code > 128) {
						System.out.println("Text includes non-ASCII Char");
						System.exit(-1);
					}
					q.push(code);
			}
			// The chars in the queue are then encoded and written into the provided txt doc
			while(!q.empty()) {
				writer.write(encode(q.pop(), keyS.generateNextKey()));
			}
			writer.close();
			
		}
		catch(NumberFormatException e) {
			System.out.println("The seed needs to be an Integer.");
		}
		catch(FileNotFoundException e) {
			System.out.println("Input file not found.");
		}
	}
}
