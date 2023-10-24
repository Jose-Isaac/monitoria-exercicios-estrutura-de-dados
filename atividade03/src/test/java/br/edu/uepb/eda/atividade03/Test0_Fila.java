package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_Fila {

	static Fila_IF f;

	@Before // Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception {
		f = new FilaComPilhas();
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(f.isEmpty());
		f.enqueue(Integer.MAX_VALUE);
		assertFalse(f.isEmpty());
	}

	@Test
	public void testEnqueueAndDequeue() throws Exception {
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);

		assertTrue(f.dequeue().equals(1));
		assertTrue(f.dequeue().equals(2));
		assertTrue(f.dequeue().equals(3));

		assertTrue(f.isEmpty());
	}

	@Test
	public void testHead() throws Exception {
		f.enqueue(1);
		f.enqueue(2);
		f.enqueue(7);
		assertTrue(f.head().equals(1));
		f.dequeue();
		assertTrue(f.head().equals(2));

		f.enqueue(90);
		assertTrue(f.head().equals(2));

		f.dequeue();
		f.dequeue();
		assertTrue(f.head().equals(90));

	}

	@Test(expected = Exception.class)
	public void testEnqueue() throws Exception {
		for (int i = 1; i <= 11; i++) {
			f.enqueue(i);
		}
	}

	@Test(expected = Exception.class)
	public void testUnderFlow() throws Exception {
		f.dequeue();
	}

	@Test(expected = Exception.class)
	public void testHeadException() throws Exception {
		f.head();
	}

}