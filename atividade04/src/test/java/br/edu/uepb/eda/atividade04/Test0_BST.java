package br.edu.uepb.eda.atividade04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

public class Test0_BST {

    static BST_IF bst;

    @BeforeEach
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsert() throws Exception {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
    }

    @Test
    public void testSearch() throws Exception { // busca existente
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        assertEquals(10, (int) bst.search(10));
        assertEquals(5, (int) bst.search(5));
        assertEquals(15, (int) bst.search(15));
        assertEquals(3, (int) bst.search(3));
        assertEquals(7, (int) bst.search(7));
        assertEquals(12, (int) bst.search(12));
        assertEquals(18, (int) bst.search(18));
    }

    @Test
    public void testPreOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        Integer[] resultado = { 10, 5, 3, 7, 15, 12, 18 };
        assertArrayEquals(resultado, bst.preOrder());
    }

    @Test
    public void testOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        Integer[] resultado = { 3, 5, 7, 10, 12, 15, 18 };
        assertArrayEquals(resultado, bst.order());
    }

    @Test
    public void testPostOrder() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        Integer[] resultado = { 3, 7, 5, 12, 18, 15, 10 };
        assertArrayEquals(resultado, bst.postOrder());
    }

    @Test
    public void testIsComplete() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
        bst.insert(18);

        assertTrue(bst.isComplete());
    }

    @Test
    public void isNotComplete() {
        bst.insert(20);
        bst.insert(23);
        bst.insert(24);
        bst.insert(21);
        bst.insert(19);

        assertFalse(bst.isComplete());
    }
}
