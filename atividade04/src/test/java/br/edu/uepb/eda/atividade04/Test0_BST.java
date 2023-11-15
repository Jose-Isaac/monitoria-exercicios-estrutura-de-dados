package br.edu.uepb.eda.atividade04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test0_BST {
    static BST_IF bst;

    @Before
    public void setupBST(){
        bst = new BST();
    }

    @Test
    public void testInsertSearch() throws Exception{
        bst.insert(7);
        bst.insert(4);
        bst.insert(2);
        bst.insert(7);
        bst.insert(3);
        assertEquals(3, bst.search(3).intValue());
    }

    @Test (expected = Exception.class)
    public void testSearchException() throws Exception{
        bst.insert(0);
        bst.insert(5);
        bst.search(9);
    }

    @Test (expected = Exception.class)
    public void testSearchExceptionEmptyTree() throws Exception{
        bst.search(5);
    }

    @Test
    public void testPreOrderEmptyTree(){
        assertArrayEquals(new Integer[]{}, bst.preOrder());
    }

    @Test
    public void testPreOrder(){
        bst.insert(8);
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);

        Integer[] expected = {8, 4, 2, 6, 12, 10, 14};

        assertArrayEquals(expected, bst.preOrder());
    }

    @Test
    public void testOrderEmptyTree(){
        assertArrayEquals(new Integer[]{}, bst.order());
    }

    @Test
    public void testOrder(){
        bst.insert(8);
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);

        Integer[] expected = {2, 4, 6, 8, 10, 12, 14};

        assertArrayEquals(expected, bst.order());
    }

    @Test
    public void testPostOrderEmptyTree(){
        assertArrayEquals(new Integer[]{}, bst.postOrder());
    }

    @Test
    public void testPostOrder(){
        bst.insert(8);
        bst.insert(4);
        bst.insert(2);
        bst.insert(6);
        bst.insert(12);
        bst.insert(10);
        bst.insert(14);

        Integer[] expected = {2, 6, 4, 10, 14, 12, 8};

        assertArrayEquals(expected, bst.postOrder());
    }

    @Test
    public void testIsCompleteEmptyTree(){
        assertEquals(false, bst.isComplete());
    }

    @Test
    public void testIsCompleteFalse(){
        bst.insert(8);
        bst.insert(9);
        bst.insert(10);
        assertEquals(false, bst.isComplete());
    }

    @Test
    public void testIsCompleteTrue(){
        bst.insert(7);
        bst.insert(4);
        bst.insert(12);
        assertEquals(true, bst.isComplete());
    }
}
