package atividade04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testeTabelaHash {

    TabelaHash tabela;

    @BeforeEach
    public void setUp() throws Exception {
        tabela = new TabelaHash(8);
    }

    @Test
    public void testInsert() {
        tabela.insert(16);
        tabela.insert(24);
        tabela.insert(3);
        tabela.insert(11);
        tabela.insert(19);
        tabela.insert(4);
        tabela.insert(10);
        tabela.insert(6);
        tabela.insert(14);
        tabela.insert(22);
        tabela.insert(15);
        tabela.insert(12);

        String expectedOutput = "0: 24, 16\n" +
                                "1: \n" +
                                "2: 10\n" +
                                "3: 19, 11, 3\n" +
                                "4: 12, 4\n" +
                                "5: \n" +
                                "6: 22, 14, 6\n" +
                                "7: 15\n";

        assertEquals(expectedOutput, tabela.print());
    }

    @Test
    public void testRemove() throws Exception {
        tabela.insert(24);
        tabela.insert(16);
        tabela.insert(10);
        tabela.insert(19);

        tabela.remove(16);
        tabela.remove(10);

        String expectedOutput = "0: 24\n" +
                                "1: \n" +
                                "2: \n" +
                                "3: 19\n" +
                                "4: \n" +
                                "5: \n" +
                                "6: \n" +
                                "7: \n";

        assertEquals(expectedOutput, tabela.print());
    }

  
    @Test
    public void testSearch() throws Exception {
        tabela.insert(24);
        tabela.insert(16);
        tabela.insert(10);
        tabela.insert(19);

        assertEquals(16, tabela.search(16));
        assertEquals(10, tabela.search(10));
        assertEquals(19, tabela.search(19));
    }

}
