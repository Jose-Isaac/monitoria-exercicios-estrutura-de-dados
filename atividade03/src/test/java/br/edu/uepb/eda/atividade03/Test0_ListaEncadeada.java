package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_ListaEncadeada {

	static ListaEncadeada_IF l;

	@Before //Instanciando a Lista antes de cada teste
	public void instanciaLista() {
		l = new ListaEncadeada();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(l.isEmpty());
		l.insert(1);
		assertFalse(l.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, l.size());
		l.insert(1);
		assertEquals(1, l.size());
		l.insert(2);
		assertEquals(2, l.size());
		l.remove(1);
		assertEquals(1, l.size());
	}

	@Test
	public void testSearch() throws Exception {
		l.insert(1);
		l.insert(2);
		l.insert(3);

		assertEquals(Integer.valueOf(1), l.search(1));
		assertEquals(Integer.valueOf(2), l.search(2));
		assertEquals(Integer.valueOf(3), l.search(3));

		try {
			l.search(4);
			fail("Deveria lançar uma exceção");
		} catch (Exception e) {
			assertEquals("Elemento não encontrado", e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		l.insert(1);
		assertEquals(1, l.toArray()[0]);
		l.insert(2);
		assertEquals(2, l.toArray()[0]);
		assertEquals(1, l.toArray()[1]);
	}

	@Test
	public void testRemove() {
		l.insert(1);
		l.insert(2);
		l.insert(3);

		l.remove(2);
		assertArrayEquals(new int[]{3, 1}, l.toArray());

		l.remove(3);
		assertArrayEquals(new int[]{1}, l.toArray());

		l.remove(1);
		assertTrue(l.isEmpty());
	}
}
