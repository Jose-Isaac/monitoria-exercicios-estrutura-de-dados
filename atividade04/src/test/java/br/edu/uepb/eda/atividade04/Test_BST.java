package br.edu.uepb.eda.atividade04;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class Test_BST {
    private BST minhaArvore;

    @Before
    public void setUp() {
        minhaArvore = new BST(null);
    }

    @Test
    public void testInsert() throws Exception {
        minhaArvore.insert(8);
        minhaArvore.insert(12);
        assertTrue(minhaArvore.search(8) != null);
        assertTrue(minhaArvore.search(12) != null);
    }

    @Test
    public void testPreOrder() {
        minhaArvore.insert(8);
        minhaArvore.insert(12);
        minhaArvore.insert(4);
        int[] expected = {8, 4, 12};
        assertArrayEquals(expected, minhaArvore.preOrder());
    }

    @Test
    public void testOrder() {
        minhaArvore.insert(8);
        minhaArvore.insert(12);
        minhaArvore.insert(4);
        int[] expected = {4, 8, 12};
        assertArrayEquals(expected, minhaArvore.order());
    }

    @Test
    public void testPostOrder() {
        minhaArvore.insert(8);
        minhaArvore.insert(12);
        minhaArvore.insert(4);
        int[] expected = {4, 12, 8};
        assertArrayEquals(expected, minhaArvore.postOrder());
    }

    @Test
    public void testIsComplete() {
        minhaArvore.insert(8);
        minhaArvore.insert(12);
        minhaArvore.insert(4);
        assertTrue(minhaArvore.isComplete());
    }

    @Test(expected = Exception.class)
    public void testSearchNotFound() throws Exception {
        minhaArvore.search(10);
    }

    @Test(expected = Exception.class)
    public void testSearchEmptyTree() throws Exception {
        new BST(null).search(10);
    }
}
