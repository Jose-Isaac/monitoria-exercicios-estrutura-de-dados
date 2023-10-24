package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test0_Pilha {

	private static Pilha_IF p;

	@Before // Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception {
		p = new PilhaComLista();
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(p.isEmpty());

		p.push(7);
		assertFalse(p.isEmpty());
	}

	@Test
	public void testIsFull() throws Exception {
		assertFalse(p.isFull());

		for (int i = 1; i <= 10; i++) {
			p.push(i);
		}

		assertTrue(p.isFull());
	}

	@Test
	public void testPushAndPop() throws Exception {
		p.push(1);
		p.push(2);
		p.push(3);

		assertTrue(p.pop().equals(3));
		assertTrue(p.pop().equals(2));
		assertTrue(p.pop().equals(1));

		assertTrue(p.isEmpty());
	}

	@Test
	public void testTop() throws Exception {
		p.push(1);
		p.push(2);
		p.push(3);
		p.push(4);

		assertTrue(p.top().equals(4));
		p.pop();
		assertTrue(p.top().equals(3));
	}

	@Test(expected = Exception.class)
	public void testFullStackException() throws Exception {
		for (int i = 1; i <= 11; i++) {
			p.push(i);
		}

	}

	@Test(expected = Exception.class)
	public void testPopException() throws Exception {
		p.pop();
	}

	@Test(expected = Exception.class)
	public void testTopException() throws Exception {
		p.top();
	}
}
