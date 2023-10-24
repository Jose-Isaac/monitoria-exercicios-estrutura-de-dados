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
	}
	
	@Test
	public void testRemove(){
		for(int i=1; i <= 5; i++){
			l.insert(i);
		}
		l.remove(3);
		assertEquals(4, l.size());
	}
	
	@Test (expected = Exception.class)
	public void testBuscarInexistente() throws Exception{
		l.insert(1);
        l.insert(2);
        l.insert(3);

        l.search(4);
	}

	@Test
	public void testBuscarExistente() throws Exception{
		l.insert(1);
        l.insert(2);
        l.insert(3);

        l.search(2);
	}

	@Test
	public void testEmpty() {
		assertTrue(l.isEmpty());
	}

	@Test
	public void testNoEmpty() {
		l.insert(20);
		assertFalse(l.isEmpty());
	}

	@Test
	public void testToArray(){
		for (int i=0; i<5; i++){
			l.insert(i+1);
		}

		assertEquals(3, l.toArray()[2]);
		
	}

	@Test
	public void testInserirInicio(){
		l.insert(1);
		l.insert(2);
		l.insert(3);

		assertEquals(3, l.toArray()[0]);
	}
	
}
