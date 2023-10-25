package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_ListaEncadeada {
	static ListaEncadeada_IF lista;

	@Before //Instanciando a Lista antes de cada teste
	public void instanciaLista() {
		lista = new ListaEncadeada();
	}

	@Test
	public void testSize() {
		assertEquals(0, lista.size()); //com a lista vazia
	}

	@Test
	public void testRemove() {
		for (int i = 1; i <= 5; i++) {
			lista.insert(i);
		}
		lista.remove(3);
		assertEquals(4, lista.size());
	}

	@Test
	public void testSearch() {
		for (int i = 1; i <= 5; i++) {
			lista.insert(i);
		}
		try {
			assertEquals(2, lista.search(2).intValue());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testIsEmpty() {
		for (int i = 0; i < 5; i++) {
			lista.insert(i);
		}
		for (int i = 0; i < 5; i++) {
			lista.remove(i);
		}
		assertTrue(lista.isEmpty());
	}

	@Test
	public void testIsNotEmpty() {
		for (int i = 0; i < 5; i++) {
			lista.insert(i);
		}

		assertFalse(lista.isEmpty());
	}

	@Test
	public void testToArray() {
		final int[] array = {1, 3, 4, 5, 6};

		for (int i = 1; i <= array.length + 1; i++) {
			lista.insert(i);
		}
		lista.remove(2);
		int index = lista.size() - 1;

		// verifique que, o l.toArray ao contrário é igual ao array acima,
		// dessa forma já fica testado o método e também se a insersão está na ordem correta

		for (int i : array) {
			assertEquals(i, lista.toArray()[index--]);
		}
	}
}