package br.edu.uepb.eda.atividade04;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class Test0_TabelaHash {

    static TabelaHash_IF tabela;

    @Before
    public void setUp() {
        tabela = new TabelaHash(8);
    }

    @Test
    public void testInsert() throws Exception {
        tabela.insert(15);
        tabela.insert(10);

        assertEquals("0: \n1: \n2: 10\n3: \n4: \n5: \n6: \n7: 15\n", tabela.print());
    }

    @Test
    public void testRemove() throws Exception {
        tabela.insert(5);
        tabela.insert(10);
        tabela.remove(5);

        assertFalse(tabela.print().contains("0: 5"));
    }

    @Test
    public void testSearch() throws Exception {
        tabela.insert(7);
        tabela.insert(14);

        assertEquals(7, tabela.search(7));
    }

    @Test
    public void testSearchNot() throws Exception {
        try {
            tabela.search(3);
        } catch (Exception e) {
            assertEquals("Elemento nao encontrado na tabela", e.getMessage());
        }
    }

    @Test
    public void testPrint() {
        tabela.insert(8);
        tabela.insert(15);
        tabela.insert(12);
        tabela.insert(21);
        tabela.insert(4);
        tabela.insert(27);

        assertEquals("0: 8\n1: \n2: \n3: 27\n4: 4, 12\n5: 21\n6: \n7: 15\n", tabela.print());
    }
}

