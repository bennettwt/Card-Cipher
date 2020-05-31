/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

public class ULStack<E> implements Cloneable {
	private Node head;
	private static int START_SIZE = 0;
	private int size;

	
	private static class Node<E>{
		E data;
		Node<E> next;
		
		Node(E item){
			data = item;
			next = null;
		}
	}
	// Stack Constructor
	public ULStack() {
		head = new Node(null);
		this.size = START_SIZE;
	}
	
	// Adds Item to top of stack
	public void push(E item) {
		Node newNode = new Node(item);
		if(empty()) {
			head.next = newNode;
		}
		else {
			newNode.next = head.next;
			head.next = newNode;
		}
		size++;
	}
	
	// Returns and removes top Item
	public E pop() throws ULEmptyStackException {
		if(empty()) {
			throw new ULEmptyStackException();
		}
		E returnItem = this.top();
		size--;
		head.next = head.next.next;
		return returnItem;
	}
	
	public E top() throws ULEmptyStackException {
		if(empty()) {
			throw new ULEmptyStackException();
		}
		else {
			return (E) head.next.data;
		}
	}
	// returns current size of stack
	public int size() {
		return size;
	}
	// returns true if stack is empty, false if not
	public boolean empty() {
		return (size == 0);
	}
	// creates shallow copy of stack
	public ULStack<E> clone() {
		ULStack<E> stackClone = new ULStack<E>();
		Node cursorOriginal = this.head;
		Node cursorClone = stackClone.head;
		for(int i = 0; i < this.size; i++) {
			Node newNode = new Node(cursorOriginal.next.data);
			cursorClone.next = newNode;
			cursorClone = cursorClone.next;
			cursorOriginal = cursorOriginal.next;
		}
		stackClone.size = this.size;
		return stackClone;
		
	}
	// clears the stack and resets size;
	public void clear() {
		head.next = null;
		size = START_SIZE;
	}
}
