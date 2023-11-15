package br.edu.uepb.eda.atividade04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;


public class Test0_TabelaHash {
    static TabelaHash_IF hashTable;

    @Before
    public void setupHashTable(){
        hashTable = new TabelaHash(8);
        hashTable.insert(5);
        hashTable.insert(8);
        hashTable.insert(0);
        hashTable.insert(7);
        
    }


    @Test
    public void testInsertSearch() throws Exception{
        assertEquals(8, hashTable.search(8).intValue());
        assertEquals(0, hashTable.search(0).intValue());

    }

    @Test (expected = Exception.class)
    public void testInsertSearchException() throws Exception{
        hashTable.search(16);
        hashTable.search(15);

    }

    @Test
    public void testRemoveHeadElement() throws Exception{
        hashTable.remove(0);
        assertThrows(Exception.class, () -> {
            hashTable.search(0);
        });

    }

    @Test
    public void testRemoveMiddleListElement() throws Exception{
        hashTable.insert(16);
        hashTable.remove(8);
        assertThrows(Exception.class, () -> {
            hashTable.search(8);
        });
        //tenta remover o 8, sendo que a lista se encontra da seguinte forma:
        /*
         * index 0: 0 -> 8 -> 16
         * deve ficar: 0 -> 16
         */
    }

    @Test (expected = Exception.class)
    public void testRemoveInexistentElement() throws Exception{
        hashTable.remove(97);

    }

    @Test
    public void testPrintTable() {
        hashTable.insert(3);
        hashTable.insert(4);
        hashTable.insert(5);

        String tablePrinted = hashTable.print();
        String expected = 
            "0: 0, 8\n1: \n2: \n3: 3\n4: 4\n5: 5, 5\n6: \n7: 7\n";

        assertEquals(expected, tablePrinted);
    }
}
