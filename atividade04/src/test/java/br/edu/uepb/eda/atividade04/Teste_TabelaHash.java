package br.edu.uepb.eda.atividade04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Teste_TabelaHash {
	private TabelaHash tabela;

    @Before
    public void setUp() {
        tabela = new TabelaHash(5); 
    }

    @Test
    public void testInsert() {
        tabela.insert(10);
        assertEquals("0: 10\n1: \n2: \n3: \n4: \n", tabela.print());
    }

    @Test
    public void testRemove() throws Exception {
        tabela.insert(10);
        tabela.insert(15);
        tabela.remove(10);
        assertEquals("0: 15\n1: \n2: \n3: \n4: \n", tabela.print());
    }

    @Test
    public void testSearch() throws Exception {
        tabela.insert(10);
        tabela.insert(15);
        assertEquals(10, tabela.search(10));
    }

    @Test(expected = Exception.class)
    public void testSearchElementNotFound() throws Exception {
        tabela.insert(10);
        tabela.search(15);
    }

    @Test
    public void testPrint() {        
        tabela.insert(10);
        tabela.insert(15);
        assertEquals("0: 15, 10\n1: \n2: \n3: \n4: \n", tabela.print());
    }
}
