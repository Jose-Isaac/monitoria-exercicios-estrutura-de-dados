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
		f.enqueue(100);
		assertFalse(f.isEmpty());
	}
	
	@Test
	public void testCheia() throws Exception{
		for(int i=0;i<10;i++){
			f.enqueue(i);
		}
		assertTrue(f.isFull());
	}

	@Test
	public void testHead() throws Exception{
		for(int i=0;i<10;i++){
			f.enqueue(i);
		}
		Integer x = 0;
		assertEquals(x, f.head());
	}
	
	@Test (expected = Exception.class)
	public void testUnderFlow() throws Exception{
		f.dequeue();
	}
	
	@Test (expected = Exception.class)
	public void testOverFlow() throws Exception{
		for(int i=0;i<=10;i++){
			f.enqueue(i);
		}
	}


}