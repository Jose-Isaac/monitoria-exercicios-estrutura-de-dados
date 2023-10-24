package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;


public class Test0_Pilha {

	private static Pilha_IF p;

	@Before //Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception {
		p = new PilhaComLista();
	}

	@Test
	public void testPushAndPop() throws Exception {
		p.push(1);
		p.push(2);
		p.push(3);

		assertEquals(Integer.valueOf(3), p.pop());
		assertEquals(Integer.valueOf(2), p.pop());
		assertEquals(Integer.valueOf(1), p.pop());
	}

	@Test
	public void testTop() throws Exception {
		p.push(1);
		p.push(2);
		p.push(3);

		assertEquals(Integer.valueOf(3), p.top());
		p.pop();
		assertEquals(Integer.valueOf(2), p.top());
	}

	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(p.isEmpty());
		p.push(1);
		assertFalse(p.isEmpty());
		p.pop();
		assertTrue(p.isEmpty());
	}

	@Test
	public void testIsFull() throws Exception {
		assertFalse(p.isFull());

		for (int i = 0; i < 10; i++) {
			p.push(i);
		}

		assertTrue(p.isFull());
	}
}