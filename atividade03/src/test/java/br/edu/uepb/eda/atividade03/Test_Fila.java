package br.edu.uepb.eda.atividade03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Fila {
	static Fila_IF fila;

	@BeforeEach //Instanciando a Fila antes de cada teste
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
		assertEquals(Integer.MAX_VALUE, fila.head());
	}

	@Test
	public void testDequeue() throws Exception {
		try {
			for (int i = 0; i < 5; i++)
				fila.enqueue(i);
			assertEquals(0, fila.dequeue());
			assertEquals(1, fila.head());
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Test
	public void testHead() throws Exception {
		for (int i = 0; i < 5; i++) fila.enqueue(i);
		assertEquals(0, fila.head());
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
