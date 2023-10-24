package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_Fila {
	
	static Fila_IF f ;
		
	@Before //Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception{
		f = new FilaComPilhas();
	}
	
	@Test
	public void testVazia() throws Exception{
		f.enqueue(Integer.MAX_VALUE);
		assertFalse(f.isEmpty());
	}
	
	@Test (expected = Exception.class)
	public void testUnderFlow() throws Exception{
		f.dequeue();
	}
	
	@Test
	public void testEnqueue() throws Exception {
		f.enqueue(10);
		assertFalse(f.isEmpty());
	}
	
	@Test
	public void testDequeue() throws Exception {
		assertTrue(f.isEmpty());
		f.enqueue(10);
		assertFalse(f.isEmpty());
		assertEquals(Integer.valueOf(10), f.dequeue());
		assertTrue(f.isEmpty());
	}
	//Outros testes ...

}
