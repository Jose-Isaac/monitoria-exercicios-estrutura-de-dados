package atividade03;

import static org.junit.Assert.*;

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
