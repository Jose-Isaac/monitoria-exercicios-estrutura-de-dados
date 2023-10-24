package atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Teste_Pilha {

	private static Pilha_IF pilha ;
	
	@Before //Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception{
		pilha = new PilhaComLista();
	}
	
	@Test
	public void testVazia() throws Exception{
		assertTrue(pilha.isEmpty());
	}
	
	@Test
	public void testPushEPop() throws Exception{
		pilha.push(250);
		assertTrue(pilha.pop() == 250);
	}
		
	@Test
	public void testTopo() throws Exception{
		pilha.push(125);
		pilha.push(253);
		assertTrue(pilha.pop() == 253);
	}
	
	@Test
	public void testCheia() throws Exception{
		int i;
		for(i = 1; i <= 10; i++) {
			pilha.push(i);
		}
		assertTrue(pilha.isFull());
	}

}
