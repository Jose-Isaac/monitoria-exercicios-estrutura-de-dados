package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_ListaEncadeada {

	static ListaEncadeada_IF l;

	@Before // Instanciando a Lista antes de cada teste
	public void instanciaLista() {
		l = new ListaEncadeada();
	}

	@Test
	public void testInsertAndSearch() throws Exception {
		l.insert(1);
		l.insert(50);
		l.insert(17);
		assertEquals(Integer.valueOf(1), l.search(1));
		assertEquals(Integer.valueOf(50), l.search(50));
		assertEquals(Integer.valueOf(17), l.search(17));
	}

	@Test
	public void testRemove() throws Exception {
		l.insert(1);
		l.insert(2);
		l.insert(3);

		l.remove(2);
		l.remove(7);

		assertEquals(2, l.size());

	}

	@Test
	public void testSizeAndIsEmpty() {
		assertTrue(l.isEmpty());
		l.insert(99);
		assertEquals(1, l.size());
		assertFalse(l.isEmpty());
	}

	@Test
	public void testToArray() {
		l.insert(100);
		l.insert(200);
		l.insert(300);

		l.remove(100);
		l.remove(300);
		int[] expectedArray = { 200 };
		assertArrayEquals(expectedArray, l.toArray());
	}

	@Test(expected = Exception.class)
	public void testSearchException() throws Exception {
		l.search(7);
	}

}