package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_ListaEncadeada {
	static ListaEncadeada_IF l;

	@Before
	public void instanciaLista() {
		l = new ListaEncadeada(); // Instanciando a Lista antes de cada teste
	}

	@Test
	public void testSize() {
		assertEquals(0, l.size()); // com a l vazia
		l.insert(1);
		assertEquals(1, l.size()); // com a l não vazia
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
	public void testIsEmpty() {
		assertTrue(l.isEmpty());
		l.insert(1);
		assertFalse(l.isEmpty());
	}

	@Test
	public void testSearch() throws Exception {
		l.insert(1);
		l.insert(2);
		l.insert(3);
		assertEquals(Integer.valueOf(1), l.search(1));
		assertEquals(Integer.valueOf(2), l.search(2));
		assertEquals(Integer.valueOf(3), l.search(3));
		assertThrows(Exception.class, () -> l.search(4));
	}

	@Test
	public void testInsert() {
		l.insert(1);
		assertEquals(1, l.size());
		assertEquals(1, l.toArray()[0]);
		l.insert(2);
		assertEquals(2, l.size());
		assertEquals(2, l.toArray()[0]);
		assertEquals(1, l.toArray()[1]);
	}

	@Test
	public void testToArray() {
		for (int i = 0; i < 5; i++) {
			l.insert(i);
		}
		l.remove(0);
		assertArrayEquals(new int[] { 4, 3, 2, 1 }, l.toArray());
	}
}
