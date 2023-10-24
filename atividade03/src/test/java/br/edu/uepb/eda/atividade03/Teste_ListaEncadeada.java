package atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class Teste_ListaEncadeada {
	
	private static ListaEncadeada_IF listaEncadeada;

	@Before //Instanciando a Lista Encadeada antes de cada teste
	public void instanciaListaEncadeada() throws Exception{
		listaEncadeada = new ListaEncadeada();
	}
	
	@Test
	public void testVazia() {
		assertTrue(listaEncadeada.isEmpty());
	}
	
	@Test
	public void testSize() {
		assertEquals(listaEncadeada.size(), 0);
	}
	
	@Test
	public void testInsertERemove() {
		listaEncadeada.insert(100);
		listaEncadeada.insert(200);
		listaEncadeada.remove(200);
		assertEquals(listaEncadeada.size(), 1);
	}

	@Test
	public void testSearch() throws Exception {
		listaEncadeada.insert(600);
		listaEncadeada.insert(200);
		assertTrue(listaEncadeada.search(600) == 600);
	}
	
	@Test
	public void testToArray() throws Exception {
		listaEncadeada.insert(600);
		listaEncadeada.insert(200);
		listaEncadeada.insert(500);
		assertTrue(listaEncadeada.toArray()[0] == 500 
				&& listaEncadeada.toArray()[2] == 600);
	}
}
