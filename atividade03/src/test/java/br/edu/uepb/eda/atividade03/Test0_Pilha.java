package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
	public void testVazia2() throws Exception{
		p.push(10);
		assertFalse(p.isEmpty());
	}
	
	@Test
	public void testCheia() throws Exception{
		p.push(10);
		assertFalse(p.isFull());
	}
	
	@Test
	public void testCheia2() throws Exception{
		for(int i=0;i<10;i++){
			p.push(i);
		}
		assertTrue(p.isFull());
	}
	
	@Test
	public void testPop() throws Exception{
		p.push(10);
		Integer x = 10;
		assertEquals(x, p.pop());
	}
	
	@Test
	public void testTop() throws Exception{
		p.push(10);
		p.push(20);
		p.push(5);
		p.pop();
		Integer x = 20;
		assertEquals(x, p.top());
	}
	
	@Test (expected = Exception.class)
	public void testUnderFlow() throws Exception{
		p.pop();
	}
	
	@Test (expected = Exception.class)
	public void testOverFlow() throws Exception{
		for(int i=0;i<=10;i++){
			p.push(i);
		}
	}
	
	
}