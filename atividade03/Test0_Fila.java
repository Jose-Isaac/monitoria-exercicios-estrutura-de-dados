package atividade03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Test0_Fila {

	static Fila_IF f;

	@Before
	public void instanciaFila() throws Exception {
		f = new FilaComPilhas();
	}

	@Test
	public void testVazia() throws Exception {
		f.enqueue(Integer.MAX_VALUE);
		assertFalse(f.isEmpty());
	}

	@Test(expected = Exception.class)
	public void testUnderFlow() throws Exception {
		f.dequeue();
	}

	@Test
	public void testDequeue() throws Exception {
		f.enqueue(10);
		f.enqueue(20);
		f.enqueue(30);

		assertEquals(10, f.dequeue());
		assertEquals(20, f.dequeue());
		assertEquals(30, f.dequeue());
		assertTrue(f.isEmpty());
	}

	@Test
	public void testHead() throws Exception {
		f.enqueue(10);
		f.enqueue(20);
		f.enqueue(30);
		assertEquals(10, f.head());
		f.dequeue();
		f.dequeue();
		f.dequeue();
		assertTrue(f.isEmpty());
	}

	@Test
	public void testFull() throws Exception {
		assertFalse(f.isFull());
		f.enqueue(10);
		assertFalse(f.isFull());
		f.enqueue(20);
		f.enqueue(30);
		assertFalse(f.isFull());
		f.dequeue();
		assertFalse(f.isFull());
	}

	@Test
	public void testEnqueueEDequeue() throws Exception {
		f.enqueue(10);
		f.enqueue(20);
		f.enqueue(30);
		assertEquals(10, f.dequeue());
		assertEquals(20, f.dequeue());
		f.enqueue(40);
		f.enqueue(50);
		assertEquals(30, f.dequeue());
		assertEquals(40, f.dequeue());
		assertEquals(50, f.dequeue());
		assertTrue(f.isEmpty());
	}

	@Test
	public void testFullEnqueue() throws Exception {
		assertFalse(f.isFull());
		for (int i = 1; i <= 10; i++) {
			f.enqueue(i);
		}
		assertTrue(f.isFull());
		Assertions.assertThrows(Exception.class, () -> {
			f.enqueue(11);
		});
	}

}
