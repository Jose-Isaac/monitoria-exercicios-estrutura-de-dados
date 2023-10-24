package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Test0_Pilha {

    private static Pilha_IF p;

    @Before
    public void instanciaPilha() throws Exception {
        p = new PilhaComLista();
    }

    @Test
    public void testVazia() {
        assertTrue(p.isEmpty());
    }

    //Outros testes ...
}
