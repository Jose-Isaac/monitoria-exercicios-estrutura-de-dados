package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_Pilha {

	private static Pilha_IF p ;
	
	@Before //Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception{
		p = new PilhaComLista();
	}
	
	@Test
	public void testVazia() throws Exception{
		assertTrue(p.isEmpty());
	}
	
	@Test
	public void testPush() throws Exception {
		p.push(10);
		assertFalse(p.isEmpty());
	}
	
	@Test
	public void testCheio() throws Exception {
		for (int i = 0; i < 10; i++) {
			p.push(i);
		}
		assertTrue(p.isFull());
	}
	//Outros testes ...
	
}
