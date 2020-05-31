/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */

package cipher;

public class ULQueue<E> implements Cloneable {
	private E[] data;
	private int size;
	private int first;
	private int last;
	private static int INITIAL_CAPACITY = 16;
	private static int INITIAL_SIZE = 0;
	private static int INITIAL_FIRST = 0;
	
	public ULQueue() {
		data = (E[]) new Object[INITIAL_CAPACITY];
		size = INITIAL_SIZE;
		first = INITIAL_FIRST;
		last = (data.length - 1);
		
	}
	
	public ULQueue(int initialCapacity) {
		data = (E[]) new Object[initialCapacity];
		size = INITIAL_SIZE;
		first = INITIAL_FIRST;
		last = (data.length - 1);
	}
	
	public void push(E item) {
		if(size == data.length){
			doubleCapacity();
		}
		last++;
		if(last == data.length){
			last = 0;
		}
		data[last] = item;
		size++;
	}
	
	public E front() throws ULEmptyQueueException{
		if(size == 0) {
			throw new ULEmptyQueueException();
		}
		return data[first];
	}
	
	public E pop() throws ULEmptyQueueException{
		if(size == 0) {
			throw new ULEmptyQueueException();
		}
		E returnItem = data[first];
		data[first] = null;
		first++;
		if(first == data.length) {
			first = 0;
		}
		size--;
		return returnItem;
	}
	
	public boolean empty() {
		return (data[first] == null);
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		// set all the things to null so GC can eat them
		for(int i = 0; i < size; i++) {
			data[first] = null;
			first++;
			if(first == data.length) {
				first = 0;
			}
		}
		size = INITIAL_SIZE;
	}
	
	public ULQueue<E> clone(){
		ULQueue<E> copyQueue = new ULQueue<E>(data.length);
		System.arraycopy(this.data, 0, copyQueue.data,0, data.length);
		copyQueue.first = this.first;
		copyQueue.last = this.last;
		copyQueue.size = this.size;
		return copyQueue;
		
		
	}
	
	public int capacity() {
		return data.length;
	}
	
	public String toString(int i) {
		return (String) data[i];
	}
	
	private void doubleCapacity() {
		E[] newData = (E[]) new Object[this.capacity() * 2];
		//copy old array contents into the new one
		for(int i = first; i < data.length; i++) {
			newData[i] = data[i]; 
		}
		if(first != 0) {
			for(int i = 0; i < first; i++) {
				newData[i] = data[i];
			}
			last = first + data.length;
		}
		
		data = newData;
	}
}
