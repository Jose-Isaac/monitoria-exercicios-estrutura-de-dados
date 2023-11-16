package atividade04;

import org.junit.Assert;
import org.junit.Test;

public class TesteBST {

    @Test
    public void testIsComplete_EmptyTree() {
        BST bst = new BST();
        Assert.assertTrue(bst.isComplete());
    }

    @Test
    public void testIsComplete_SingleNode() {
        BST bst = new BST();
        bst.insert(10);
        Assert.assertTrue(bst.isComplete());
    }

    @Test
    public void testIsComplete_CompleteTree() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        Assert.assertTrue(bst.isComplete());
    }

    @Test
    public void testIsComplete_IncompleteTree() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(18);
        Assert.assertFalse(bst.isComplete());
    }

    @Test
    public void testIsComplete_NotCompleteTree() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(9);
        Assert.assertFalse(bst.isComplete());
    }

    @Test(expected = Exception.class)
    public void testSearch_NotFound() throws Exception {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        bst.search(7);
    }

    @Test
    public void testPreOrder() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(16);

        int[] expected = {10, 5, 3, 7, 15, 12, 16};
        Assert.assertArrayEquals(expected, bst.preOrder());
    }

    @Test
    public void testOrder() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(16);

        int[] expected = {3, 5, 7, 10, 12, 15, 16};
        Assert.assertArrayEquals(expected, bst.order());
    }

    @Test
    public void testPostOrder() {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(16);

        int[] expected = {3, 7, 5, 12, 16, 15, 10};
        Assert.assertArrayEquals(expected, bst.postOrder());
    }

}
