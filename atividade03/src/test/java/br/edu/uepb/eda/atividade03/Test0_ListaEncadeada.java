package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_ListaEncadeada {
	
	static ListaEncadeada_IF l ;
		
	@Before //Instanciando a Lista antes de cada teste
	public void instanciaLista(){
		l = new ListaEncadeada();
	}
	
	@Test
	public void testSize(){
		assertEquals(0, l.size()); //com a lista vazia
		l.insert(10);
		assertEquals(1, l.size());
		l.insert(15);
		assertEquals(2, l.size());
	}
	
	@Test
	public void testEmpty() {
		assertTrue(l.isEmpty());
		l.insert(10);
		assertFalse(l.isEmpty());
	}
	
	@Test
	public void testRemove(){
		for(int i=1; i <= 5; i++){
			l.insert(i);
		}
		l.remove(3);
		assertEquals(4, l.size());
		l.remove(1);
		assertEquals(3, l.size());
	}		
}
