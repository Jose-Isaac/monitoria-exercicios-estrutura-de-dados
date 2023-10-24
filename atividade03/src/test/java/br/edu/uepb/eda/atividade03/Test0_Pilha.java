package br.edu.uepb.eda.atividade03;

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
    @Test
    public void testPushAndTop() {
        try {
            p.push(20);
            assertFalse(p.isEmpty());
            assertEquals(20, p.top(), 0);
            assertFalse(p.isEmpty());
        } catch (Exception e) {
            fail("Exceção lançada: " + e.getMessage());
        }
    }

    @Test
    public void testIsFull() {
        assertFalse(p.isFull());

        for (int i = 0; i < 10; i++) {
            try {
                p.push(i);
            } catch (Exception e) {
                fail("Exceção lançada: " + e.getMessage());
            }
        }

        assertTrue(p.isFull());
    }

    @Test(expected = Exception.class)
    public void testPushWhenFull() throws Exception {
        for (int i = 0; i < 11; i++) {
            p.push(i);
        }
    }

    @Test
    public void testPushAndPopSequence() {
        try {
            for (int i = 1; i <= 5; i++) {
                p.push(i);
            }
            for (int i = 5; i >= 1; i--) {
                assertEquals(i, p.pop(), 0);
            }
            assertTrue(p.isEmpty());
        } catch (Exception e) {
            fail("Exceção lançada: " + e.getMessage());
        }
    }

}
