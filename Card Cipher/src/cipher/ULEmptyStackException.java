/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

public class ULEmptyStackException extends java.lang.RuntimeException {
	
	// an exception when trying to pop an empty stack
	public ULEmptyStackException() {
		super();
	}
	
	public ULEmptyStackException(String message) {
		super(message);
	}

}
