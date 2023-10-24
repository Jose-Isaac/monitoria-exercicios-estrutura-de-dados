package br.edu.uepb.eda.atividade03;

import static org.junit.Assert.*;

public class Test0_ListaEncadeada {

    static ListaEncadeada_IF l;

    @Before //Instanciando a Lista antes de cada teste
    public void instanciaLista() {
        l = new ListaEncadeada();
    }

    @Test
    public void testSize() {
        assertEquals(0, l.size(), 0); //com a lista vazia
    }

    @Test
    public void testRemove() {
        for (int i = 1; i <= 5; i++) {
            l.insert(i);
        }
        l.remove(3);
        assertEquals(4, l.size(), 0);
    }

    //Outros testes ...
}
