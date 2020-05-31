/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;


public class ULEmptyQueueException extends java.lang.RuntimeException {
	
	// an exception when trying to pop an empty queue
	public ULEmptyQueueException() {
		super();
	}
	
	public ULEmptyQueueException(String message) {
		super(message);
	}

}
