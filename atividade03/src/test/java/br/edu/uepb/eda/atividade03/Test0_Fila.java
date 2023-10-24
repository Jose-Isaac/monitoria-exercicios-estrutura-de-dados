package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_Fila {

    static Fila_IF f;

    @Before //Instanciando a Fila antes de cada teste
    public void instanciaFila() throws Exception {
        f = new FilaComPilhas();
    }

    @Test
    public void testVazia() throws Exception {
        f.enqueue(Integer.MAX_VALUE);
        assertFalse(f.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testUnderFlow() throws Exception {
        f.dequeue();
    }

    //Outros testes ...
    
    @Test
    public void testEnqueueAndDequeue() throws Exception {
        f.enqueue(10);
        f.enqueue(20);

        assertEquals(10, f.dequeue());
        assertEquals(20, f.dequeue());
        assertTrue(f.isEmpty());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(f.isEmpty());

        try {
            f.enqueue(10);
            assertFalse(f.isEmpty());

            f.dequeue();
            assertTrue(f.isEmpty());
        } catch (Exception e) {
            fail("Exceção lançada: " + e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testEnqueueWhenFull() throws Exception {
        for (int i = 0; i < 11; i++) {
            f.enqueue(i);
        }
    }
}
