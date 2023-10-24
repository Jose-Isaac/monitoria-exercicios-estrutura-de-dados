package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_ListaEncadeada {

	private static ListaEncadeada_IF l ;
	
	@Before //Instanciando a Lista antes de cada teste
	public void instanciaLista(){
		l = new ListaEncadeada();
	}
	
	@Test
	public void testSize(){
		assertEquals(0, l.size()); //com a lista vazia
	}
	
	@Test
	public void testRemove(){
		for(int i=1; i <= 5; i++){
			l.insert(i);
		}
		l.remove(3);
		assertEquals(4, l.size());
	}
	
	@Test
	public void testEmpty() {
		assertTrue(l.isEmpty());
	}
	
	@Test
	public void testSearch() throws Exception {
		for(int i=1; i <= 5; i++){
			l.insert(i);
		}
		assertEquals(3, (int) l.search(3));
	}
	
	@Test
	public void testInsert() throws Exception {
		l.insert(1);
		assertEquals(1, (int) l.search(1));
	}
	
	@Test
	public void testToArray() {
		for(int i=1; i <= 5; i++){
			l.insert(i);
		}
		int[] result = l.toArray();
		assertEquals(5, result[0]);
	}
	
}
