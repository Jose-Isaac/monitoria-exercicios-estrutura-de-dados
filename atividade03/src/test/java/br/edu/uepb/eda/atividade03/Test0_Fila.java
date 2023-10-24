package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_Fila {
	private static Fila_IF f ;
	
	@Before //Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception{
		f = new FilaComPilhas();
	}
	
	@Test
	public void testVazia() throws Exception{
		f.enqueue(10);
		assertFalse(f.isEmpty());
	}
	
	@Test (expected = Exception.class)
	public void testUnderFlow() throws Exception{
		f.dequeue();
	}
	
	@Test
	public void testHead() throws Exception {
		for (int i = 1; i <= 3; i++) {
			f.enqueue(i);
		}
		assertEquals(1, (int) f.head());
	}
	
	@Test (expected = Exception.class)
	public void testFull() throws Exception{
		for (int i = 1; i <= 10; i++) {
			f.enqueue(i);
		}
		f.enqueue(11);
	}
}
