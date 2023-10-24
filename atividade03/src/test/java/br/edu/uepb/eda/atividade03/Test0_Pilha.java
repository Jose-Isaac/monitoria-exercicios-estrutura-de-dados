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
		p.push(1);
		p.push(2);
	}
	
	@Test
	public void testPop() throws Exception {
		p.push(1);
		p.push(2);
		
		assertEquals(Integer.valueOf(2), p.pop());
		assertEquals(Integer.valueOf(1), p.pop());
	}
	
	@Test
	public void testTop() throws Exception {
		p.push(1);
		assertEquals(Integer.valueOf(1), p.top());
		p.push(2);
		assertEquals(Integer.valueOf(2), p.top());
	}
	@Test
	public void testIsEmpty() throws Exception {
		assertTrue(p.isEmpty());
		p.push(1);
		assertFalse(p.isEmpty());
	}
	@Test(expected = Exception.class)
	public void testPopFromEmptyStack() throws Exception{
		p.pop();
	}
	@Test
	public void testFull() {		
		assertFalse(p.isFull());
		for(int i = 0; i < 12; i++) {
			try {
				p.push(i);
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		assertTrue(p.isFull());
	}
}
