package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;

public class BST implements BST_IF {
    protected Integer data;
    protected BST left;
    protected BST right;
    protected BST parent;

    @Override
    public void insert(Integer element) {
        if (this.data == null) {
            this.data = element;

            this.left = new BST();
            this.left.parent = this;

            this.right = new BST();
            this.right.parent = this;

            return;
        }

        if (element < this.data) {
            this.left.insert(element);
        }

        if (element > this.data) {
            this.right.insert(element);
        }

    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (this.data == null) {
            throw new Exception("O elemento não existe na BST!");
        }

        if (this.data.equals(element))
            return element;

        if (element < this.data)
            return this.left.search(element);

        if (element > this.data)
            return this.right.search(element);

        throw new Exception("O elemento não existe na BST!");
    }

    @Override
    public Integer[] preOrder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        preOrder(this, elements);

        Integer[] elementsInt = arrayListToIntArray(elements);
        return elementsInt;
    }

    private static void preOrder(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            elements.add(bst.data);
            preOrder(bst.left, elements);
            preOrder(bst.right, elements);
        }
    }

    @Override
    public Integer[] order() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        order(this, elements);

        Integer[] elementsInt = arrayListToIntArray(elements);
        return elementsInt;
    }

    private static void order(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            order(bst.left, elements);
            elements.add(bst.data);
            order(bst.right, elements);
        }
    }

    @Override
    public Integer[] postOrder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        postOrder(this, elements);

        Integer[] elementsInt = arrayListToIntArray(elements);
        return elementsInt;
    }

    private static void postOrder(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            postOrder(bst.left, elements);
            postOrder(bst.right, elements);
            elements.add(bst.data);
        }
    }

    @Override
    public boolean isComplete() {
        return isComplete(this, 0, height(this));
    }

    private int height(BST bst) {
        if (bst == null) {
            return 0;

        } else {
            int leftHeight = height(bst.left);
            int rightHeight = height(bst.right);

            return leftHeight < rightHeight ? leftHeight + 1 : rightHeight + 1;
        }
    }

    private boolean isComplete(BST bst, int i, int height) {
        if (bst == null && i == 0)
            return false;

        if (bst == null)
            return true;

        if (i == (height - 1))
            return bst.left == null && bst.right == null;

        else if (i > (height - 1))
            return false;

        return isComplete(bst.left, i + 1, height) && isComplete(bst.right, i + 1, height);
    }

    private static Integer[] arrayListToIntArray(ArrayList<Integer> arrayList) {
        Integer[] elementsInt = new Integer[arrayList.size()];
        for (int i = 0; i < elementsInt.length; i++) {
            elementsInt[i] = arrayList.get(i);
        }

        return elementsInt;
    }

}
