package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


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
	public void testIsFull() throws Exception{
		for (int i=0; i<11; i++){ // vai até 10
            p.push(i);
        }

        assertTrue(p.isFull());
	}

    @Test
	public void testNotIsFull() throws Exception{
		for (int i=0; i<8; i++){
            p.push(i);
        }

        assertFalse(p.isFull());
	}

    @Test (expected = Exception.class)
	public void testEstouroPilha() throws Exception{
		for (int i=0; i<12; i++){ // vai até 11
            p.push(i);
        }
	}
	
}
