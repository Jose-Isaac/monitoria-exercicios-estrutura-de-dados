package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Teste_Fila {

	private static Fila_IF fila;

	@Before // Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception {
		fila = new FilaComPilhas();
	}

	@Test
	public void testVazia() {
		assertTrue(fila.isEmpty());
	}

	@Test
	public void testEnqueueEIsFull() throws Exception {
		int i;
		for (i = 1; i <= 10; i++) {
			fila.enqueue(i);
		}
		assertTrue(fila.isFull());
	}

	@Test
	public void testDequeue() throws Exception {
		fila.enqueue(120);
		fila.enqueue(159);
		assertTrue(fila.dequeue() == 120);
	}

	@Test
	public void testHead() throws Exception {
		fila.enqueue(170);
		fila.enqueue(250);
		assertTrue(fila.head() == 170);
	}

}
