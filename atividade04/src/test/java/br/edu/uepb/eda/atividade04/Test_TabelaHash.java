package br.edu.uepb.eda.atividade04;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test_TabelaHash {

    private TabelaHash_IF t;

    @Before
    public void setUp() {
        // Inicializa a tabela antes de cada teste
        t = new TabelaHash(8);
    }

    @Test
    public void testInsertAndSearch() throws Exception {
        t.insert(17);
        t.insert(87);
        t.insert(10);

        assertEquals(Integer.valueOf(17), t.search(17));
        assertEquals(Integer.valueOf(10), t.search(10));
        assertEquals(Integer.valueOf(87), t.search(87));
    }

    @Test
    public void testRemove() throws Exception {
        t.insert(17);
        t.insert(87);
        t.insert(10);

        t.remove(87);
        assertEquals(Integer.valueOf(17), t.search(17));
        assertEquals(Integer.valueOf(10), t.search(10));

    }

    @Test
    public void testPrint() throws Exception {
        assertEquals("0: \n1: \n2: \n3: \n4: \n5: \n6: \n7: \n", t.print());

        t.insert(17);
        t.insert(87);

        assertEquals("0: \n1: 17\n2: \n3: \n4: \n5: \n6: \n7: 87\n", t.print());

        t.remove(17);

        t.insert(58);
        t.insert(59);
        t.insert(39);

        assertEquals("0: \n1: \n2: 58\n3: 59\n4: \n5: \n6: \n7: 39, 87\n", t.print());

    }

    @Test(expected = Exception.class)
    public void testSearchException() throws Exception {
        t.insert(17);
        t.search(7);
    }
}
