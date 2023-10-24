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
    public void testEmptyQueue() throws Exception {
        assertTrue(f.isEmpty());

        f.enqueue(100);
        assertFalse(f.isEmpty());

        f.dequeue();
        assertTrue(f.isEmpty());
    }


    @Test
    public void testIsCheia() throws Exception{
        for (int i=0; i<11; i++){ // até 10
            f.enqueue(i);
        }
        
        assertTrue(f.isFull());
    }

    @Test (expected = Exception.class)
    public void testEmptyHead() throws Exception{
        f.head();
    }

    @Test
    public void testExpectedHead() throws Exception{
        f.enqueue(2);
        f.enqueue(4);
        f.enqueue(8);

        assertEquals(2, f.head(), 0);
    }

}
