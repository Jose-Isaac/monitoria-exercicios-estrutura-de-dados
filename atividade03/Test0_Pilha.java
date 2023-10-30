package atividade03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Test0_Pilha {

	private static Pilha_IF p;

	@Before
	public void instanciaPilha() throws Exception {
		p = new PilhaComLista();
	}

	@Test
	public void testVazia() throws Exception {
		assertTrue(p.isEmpty());
	}

	@Test
	public void testPushAndPop() throws Exception {
		p.push(10);
		p.push(20);
		p.push(30);

		assertEquals(30, p.pop());
		assertEquals(20, p.pop());
		assertEquals(10, p.pop());

		assertTrue(p.isEmpty());
	}

	@Test
	public void testTop() throws Exception {
		p.push(10);
		p.push(20);
		p.push(30);

		assertEquals(30, p.top());

		p.pop();
		assertEquals(20, p.top());

		p.pop();
		assertEquals(10, p.top());

		p.pop();
		assertTrue(p.isEmpty());
	}

	@Test
	public void testEmptyPop() throws Exception {
		assertTrue(p.isEmpty());

		Assertions.assertThrows(Exception.class, () -> {
			p.pop();
		});
	}

	@Test
	public void testEmptyPeek() throws Exception {
		assertTrue(p.isEmpty());

		Assertions.assertThrows(Exception.class, () -> {
			p.top();
		});
	}

	@Test
	public void testIsFull() throws Exception {
		assertFalse(p.isFull());
	}
}
