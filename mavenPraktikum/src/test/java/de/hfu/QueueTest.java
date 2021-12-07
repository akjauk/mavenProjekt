package de.hfu;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class QueueTest {
	private Queue q;
	
	@Before
	public void createQueueWithLengthThree() {
		q = new Queue(3);
	}
	
	@Test
	public void testEnqueing() {
		//filling up queue with one space left
		q.enqueue(1);
		q.enqueue(2);
		
		//setting and enqueuing int
		int toEnqueue = 3;
		q.enqueue(toEnqueue);
		
		//dequeuing until getting expected result
		q.dequeue();
		q.dequeue();
		int result = q.dequeue();
		
		assertEquals(toEnqueue + " wurde erfolgreich eingefügt", toEnqueue, result);		
	}
	
	@Test
	public void testEnqueingFullQueue() {
		//filling up queue completely
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		//setting and enqueuing int
		int toEnqueue = 4;
		q.enqueue(toEnqueue);
		
		//dequeuing until getting expected result
		q.dequeue();
		q.dequeue();
		int result = q.dequeue();
		
		assertEquals("Letztes Element überschrieben mit "+ toEnqueue, toEnqueue, result);
	}
	
	@Test
	public void testDequeueingOneElement() {
		//filling up queue completely
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
				
		int toDequeue = 1;
		int result = q.dequeue();
		assertEquals(toDequeue + " wurde entnommen", toDequeue, result);
	}
	
	@Test(expected=IllegalStateException.class, timeout=1000)
	public void testDequeuingEmptyQueue() {
		q.dequeue();
		q.dequeue();
		q.dequeue();
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void testQueueWithLengthZero() {
		Queue q2 = new Queue(0);
	}
}
