package atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_ListaEncadeada {

    static ListaEncadeada_IF l;

    @Before //Instanciando a Lista antes de cada teste
    public void instanciaLista() {
        l = new ListaEncadeada();
    }

    @Test
    public void testSize() {
        assertEquals(0, l.size()); //com a lista vazia
    }

    @Test
    public void testRemove() {
        for (int i = 1; i <= 5; i++) {
            l.insert(i);
        }
        l.remove(3);
        assertEquals(4, l.size());
    }

    //Outros testes ...
    
    @Test
    public void testInsert() {
        l.insert(10);
        assertEquals(1, l.size());
    }
    
    @Test
    public void testSearch() {
        l.insert(100);
        l.insert(200);
        l.insert(300);

        try {
            assertEquals(200, (int) l.search(200));
        } catch (Exception e) {
            fail("Exceção lançada: " + e.getMessage());
        }
    }

    @Test(expected = Exception.class)
    public void testSearchNonexistent() throws Exception {
        l.insert(100);
        l.insert(200);
        l.search(300); // Elemento não existente
    }

    @Test
    public void testIsEmpty() {
        assertTrue(l.isEmpty());
        l.insert(10);
        assertFalse(l.isEmpty());
    }
    
}
