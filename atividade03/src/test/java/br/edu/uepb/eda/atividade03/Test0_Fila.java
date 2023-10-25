package br.edu.uepb.eda.atividade03;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Test0_Fila {
	static Fila_IF fila;

	@Before //Instanciando a Fila antes de cada teste
	public void instanciaFila() {
		fila = new FilaComPilhas();
	}

	@Test
	public void testVazia() throws Exception {
		fila.enqueue(Integer.MAX_VALUE);
		assertFalse(fila.isEmpty());
	}

	@Test
	public void testUnderFlow() {
		assertThrows(Exception.class, () -> fila.dequeue());
	}

	@Test
	public void testOverflow() {
		try {
			for (int i = 0; i < 10; i++)
				fila.enqueue(i);
			assertThrows(Exception.class, () -> fila.enqueue(1));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testEnqueue() throws Exception {
		fila.enqueue(Integer.MAX_VALUE);
		assertEquals(Integer.MAX_VALUE, fila.head().intValue());
	}

	@Test
	public void testDequeue() throws Exception {
		try {
			for (int i = 0; i < 5; i++)
				fila.enqueue(i);
			assertEquals(0, fila.dequeue().intValue());
			assertEquals(1, fila.head().intValue());
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Test
	public void testHead() throws Exception {
		for (int i = 0; i < 5; i++) fila.enqueue(i);
		assertEquals(0, fila.head().intValue());
	}

	@Test
	public void testIsFull() throws Exception {
		try {
			for (int i = 0; i < 10; i++)
				fila.enqueue(i);
			assertTrue(fila.isFull());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}