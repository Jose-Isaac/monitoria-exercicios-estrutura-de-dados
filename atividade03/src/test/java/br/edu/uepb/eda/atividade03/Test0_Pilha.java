package atividade03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test0_Pilha {

	private static Pilha_IF p ;
	
	@Before //Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception{
		p = new PilhaComLista();
	}
	
	@Test
	public void testEmpty() throws Exception{
		assertTrue(p.isEmpty());
	}
	
	@Test
	public void testFull() throws Exception {
		for (int i = 1; i <= 10; i++) {
			p.push(i);
		}
		assertTrue(p.isFull());
	}
	
	@Test
	public void testTop() throws Exception {
		for (int i = 1; i <= 5; i++) {
			p.push(i);
		}
		assertEquals(5, (int) p.top());
	}
	
	@Test
	public void testPush() throws Exception {
		p.push(1);
		assertEquals(1, (int) p.top());
	}
	
	@Test
	public void testPop() throws Exception {
		for (int i = 1; i <= 5; i++) {
			p.push(i);
		}
		assertEquals(5, (int) p.pop());
	}
	
}