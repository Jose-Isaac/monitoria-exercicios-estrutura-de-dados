package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_Fila {
	
	static Fila_IF f;
		
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
		f.enqueue(1);
        f.enqueue(2);
	}
	
	@Test
    public void testDequeue() throws Exception {
		f.enqueue(1);
        f.enqueue(2);

        assertEquals(Integer.valueOf(1), f.dequeue());
        assertEquals(Integer.valueOf(2), f.dequeue());
    }

    @Test
    public void testHead() throws Exception {
        f.enqueue(1);
        f.enqueue(2);

        assertEquals(Integer.valueOf(1), f.head());
        f.dequeue();
        assertEquals(Integer.valueOf(2), f.head());
    }
}
