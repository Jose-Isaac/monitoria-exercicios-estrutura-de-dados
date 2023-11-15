package br.edu.uepb.eda.atividade04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test0_TabelaHash {

    @Test
    public void testInsert() throws Exception {
        TabelaHash tabelaHash = new TabelaHash(8);

        tabelaHash.insert(24);
        tabelaHash.insert(16);
        tabelaHash.insert(10);

        assertEquals("0: 16, 24\n1: \n2: 10\n3: \n4: \n5: \n6: \n7: \n", tabelaHash.print());
    }

    @Test
    public void testSearch() throws Exception {
        TabelaHash tabelaHash = new TabelaHash(8);

        tabelaHash.insert(24);
        tabelaHash.insert(16);
        tabelaHash.insert(10);

        assertEquals(24, tabelaHash.search(24));
        assertEquals(16, tabelaHash.search(16));
        assertEquals(10, tabelaHash.search(10));

        assertThrows(Exception.class, () -> tabelaHash.search(15));
    }

    @Test
    public void testRemove() throws Exception {
        TabelaHash tabelaHash = new TabelaHash(8);

        tabelaHash.insert(24);
        tabelaHash.insert(16);
        tabelaHash.insert(10);

        tabelaHash.remove(16);
        assertEquals("0: 24\n1: \n2: 10\n3: \n4: \n5: \n6: \n7: \n", tabelaHash.print());

        assertThrows(Exception.class, () -> tabelaHash.remove(16));
    }

    @Test
    public void testPrint() {
        TabelaHash tabelaHash = new TabelaHash(8);

        tabelaHash.insert(24);
        tabelaHash.insert(16);
        tabelaHash.insert(10);
        tabelaHash.insert(19);
        tabelaHash.insert(11);
        tabelaHash.insert(3);

        assertEquals("0: 16, 24\n1: \n2: 10\n3: 3, 11, 19\n4: \n5: \n6: \n7: \n", tabelaHash.print());
    }
}
