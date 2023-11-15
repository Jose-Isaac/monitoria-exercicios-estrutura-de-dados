package br.edu.uepb.eda.atividade04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test0_BST {
    @Test
    public void testInsert() throws Exception {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertArrayEquals(new int[]{5, 3, 7}, bst.preOrder());
    }

    @Test
    public void testSearch() throws Exception {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(5, bst.search(5));
        assertEquals(3, bst.search(3));
        assertEquals(7, bst.search(7));

        assertThrows(Exception.class, () -> bst.search(10));
    }

    @Test
    public void testOrder() {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertArrayEquals(new int[]{3, 5, 7}, bst.order());
    }
}