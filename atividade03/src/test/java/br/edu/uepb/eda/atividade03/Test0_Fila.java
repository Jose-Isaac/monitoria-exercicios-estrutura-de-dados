package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_Fila {

	static Fila_IF f;

	@Before //Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception {
		f = new FilaComPilhas();
	}

	@Test
	public void testEnqueueAndDequeue() {
		try {
			f.enqueue(1);
			f.enqueue(2);
			f.enqueue(3);
		} catch (Exception e) {
			fail("Exceção inesperada: " + e.getMessage());
		}

		try {
			assertEquals(Integer.valueOf(1), f.dequeue());
			assertEquals(Integer.valueOf(2), f.dequeue());
			assertEquals(Integer.valueOf(3), f.dequeue());
		} catch (Exception e) {
			fail("Exceção inesperada: " + e.getMessage());
		}
	}

	@Test
	public void testIsEmpty() {
		assertTrue(f.isEmpty());
		try {
			f.enqueue(1);
		} catch (Exception e) {
			fail("Exceção inesperada: " + e.getMessage());
		}
		assertFalse(f.isEmpty());
	}

	@Test
	public void testHead() {
		try {
			f.enqueue(1);
			f.enqueue(2);
			f.enqueue(3);
		} catch (Exception e) {
			fail("Exceção inesperada: " + e.getMessage());
		}

		try {
			assertEquals(Integer.valueOf(1), f.head());
			f.dequeue();
			assertEquals(Integer.valueOf(2), f.head());
		} catch (Exception e) {
			fail("Exceção inesperada: " + e.getMessage());
		}
	}

	@Test
	public void testIsFull() {
		assertFalse(f.isFull());

		try {
			for (int i = 0; i < 10; i++) {
				f.enqueue(i);
			}
		} catch (Exception e) {
			fail("Exceção inesperada: " + e.getMessage());
		}

		assertTrue(f.isFull());
	}
}