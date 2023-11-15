package br.edu.uepb.eda.atividade04;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Test_TabelaHash {
    private TabelaHash minhaTabela;

    @Before
    public void setUp() {
        minhaTabela = new TabelaHash(8);
    }

    @Test
    public void testInsert() {
        minhaTabela.insert(24);
        minhaTabela.insert(16);
        assertEquals("0: 24, 16\n1: \n2: \n3: \n4: \n5: \n6: \n7: \n", minhaTabela.print());
    }

    @Test
    public void testSearch() throws Exception {
        minhaTabela.insert(24);
        minhaTabela.insert(16);
        assertEquals(0, minhaTabela.search(24));
    }

    @Test
    public void testRemove() throws Exception {
        minhaTabela.insert(24);
        minhaTabela.insert(16);
        minhaTabela.remove(24);
        assertEquals("0: 16\n1: \n2: \n3: \n4: \n5: \n6: \n7: \n", minhaTabela.print());
    }

    @Test(expected = Exception.class)
    public void testSearchNotFound() throws Exception {
        minhaTabela.search(10);
    }

    @Test(expected = Exception.class)
    public void testRemoveNotFound() throws Exception {
        minhaTabela.remove(10);
    }
}
