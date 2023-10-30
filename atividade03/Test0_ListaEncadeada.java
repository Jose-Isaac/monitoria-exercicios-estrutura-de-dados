package atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_ListaEncadeada {

	static ListaEncadeada_IF l;

	@Before
	public void instanciaLista() {
		l = new ListaEncadeada();
	}

	@Test
	public void testSize() {
		assertEquals(0, l.size());
	}

	@Test
	public void testRemove() {
		for (int i = 1; i <= 5; i++) {
			l.insert(i);
		}
		l.remove(3);
		assertEquals(4, l.size());
	}

	@Test
	public void testarSeVazio() {
		assertTrue(l.isEmpty());
	}

	@Test
	public void testarNaoVazia() {
		l.insert(1);
		assertFalse(l.isEmpty());
	}

	@Test(expected = Exception.class)
	public void procurarElementoListaVazia() throws Exception {
		l.search(2);
	}

	@Test
	public void procurarElementoListaCheia() throws Exception {
		for (int i = 0; i <= 10; i++) {
			l.insert(i);
		}
		assertEquals(8, l.search(8));
	}

	@Test
	public void testeRemoverListaVazia() {
		l.remove(1);
		assertEquals(0, l.size());
	}

	@Test
	public void testToArray() {
		l.insert(1);
		l.insert(2);
		l.insert(3);

		int[] expected = { 3, 2, 1 };
		int[] result = l.toArray();

		assertArrayEquals(expected, result);
	}

	@Test
	public void testToArrayLitaVazia() {
		int[] expected = null;
		int[] result = l.toArray();

		assertArrayEquals(expected, result);
	}
}