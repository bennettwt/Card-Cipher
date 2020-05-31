/**
 * @author Trey Bennett, Jonathan Prichett
 * CS 241
 * 4/20/20
 */


package test;

import static org.junit.jupiter.api.Assertions.*;

import cipher.ULEmptyQueueException;
import cipher.ULQueue;

import org.junit.jupiter.api.Test;

class QueueTest {

	@Test
	void testPushAndPop(){
		ULQueue<Integer> queue = new ULQueue<Integer>();
		boolean check = false;
		
		// Make sure you can't pop an empty queue and also check that the empty queue exception works
		
		try {
			queue.pop();
			check = true;
			assertTrue(check, "Exceptions are not working.");
		}
		catch(ULEmptyQueueException e) {
			assertFalse(check, "Exception working as intended.");
		}
		
		// add things to the queue
		queue.push(1);
		queue.push(2);
		queue.push(3);
		
		// make sure the front is 1
		assertEquals(queue.front(), 1);
		
		queue.pop();
		
		// make sure that pop removes the front and the front is now 2
		assertEquals(queue.front(), 2);	
		
		queue.pop();
		
		assertEquals(queue.front(), 3);
		
		queue.pop();
		
		assertTrue(queue.empty(), "list is empty");
		
	}
	
	@Test
	void testClone() {
		ULQueue<Integer> queue = new ULQueue<Integer>();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		ULQueue queueClone = queue.clone();
		
		//make sure the front is the same
		assertEquals(queue.front(), 1);
		assertEquals(queueClone.front(), 1);
		
		queueClone.pop();
		
		// editing the clone shouldn't edit the original
		assertEquals(queue.front(), 1);
		assertEquals(queueClone.front(), 2);
		
	}
	
	@Test
	void testClear() {
		ULQueue<Integer> queue = new ULQueue<Integer>();
		
		// add values from 0-19
		for(int i = 0; i < 20; i++) {
			queue.push(i);			
		}
		
		queue.clear();
		
		// make sure we reset the size
		assertEquals(queue.size(), 0);		
		
	}
	
	
	
}
