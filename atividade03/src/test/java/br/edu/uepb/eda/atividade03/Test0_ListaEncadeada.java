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
	public void testVazia() throws Exception{
		l.insert(5);
		assertFalse(l.isEmpty());
	}
	
	@Test
	public void testSize(){
		for(int i=0;i<5;i++){
			l.insert(i);
		}
		assertEquals(5, l.size()); //com a lista vazia
	}

	@Test
	public void testInsert() throws Exception{
		Integer num = 100;
		l.insert(num);
		Integer result = l.search(100);
		
		if (result != null) {
			assertEquals(num, result);
		} else {
			fail("Elemento não encontrado na lista");
		}
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
	public void testSearch() throws Exception{
		l.insert(100);
		l.insert(200);
		l.insert(300);
		
		Integer result = l.search(200);
		Integer x = 200;
		
		if (result != null) {
			assertEquals(x, result);
		} else {
			fail("Elemento não encontrado na lista");
		}
	}

	@Test
	public void testToArray() throws Exception{
		int[] array = {5,4,3,2,1};
		for(int i=1; i <= 5; i++){
			l.insert(i);
		}
		assertArrayEquals(array, l.toArray());
	}
	
	
}