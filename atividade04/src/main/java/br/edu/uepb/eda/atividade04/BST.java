package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;

public class BST implements BST_IF{
    protected Integer data;
    protected BST left;
    protected BST right;
    protected BST dad;

    @Override
    public void insert(Integer element) {
        if (this.data == null) {
            this.data = element;

            this.left = new BST();
            this.left.dad = this;

            this.right = new BST();
            this.right.dad = this;
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
            throw new Exception("Elemento não encontrado");
        }

        if (this.data.equals(element)) {
            return element;
        }
        
        if (element < this.data) {
            return this.left.search(element);
        }
        
        if (element > this.data) {
            return this.right.search(element);
        }

        throw new Exception("Elemento não encontrado");
        }

    @Override
    public Integer[] preOrder() {
        ArrayList<Integer> elements = new ArrayList<Integer>();

        preOrder(this, elements);

        Integer[] newElements = trocaElementos(elements);
        return newElements;
    }

    private Integer[] trocaElementos(ArrayList<Integer> array) {

        Integer[] elements = new Integer[array.size()];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = array.get(i);
        }
        return elements;
    }

    private void preOrder(BST bst, ArrayList<Integer> elements) {
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

        Integer[] newElements = trocaElementos(elements);
        return newElements;
    }

    private void order(BST bst, ArrayList<Integer> elements) {
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

        Integer[] newElements = trocaElementos(elements);
        return newElements;
    }

    private void postOrder(BST bst, ArrayList<Integer> elements) {
        if (bst.data != null) {
            postOrder(bst.left, elements);
            postOrder(bst.right, elements);
            elements.add(bst.data);
        }
    }

    @Override
    public boolean isComplete() {
        return isComplete(this, 0, altura(this));
    }

    private boolean isComplete(BST bst, int i, int altura) {
        if (bst == null && i == 0) {
            return false;
        }

        if (bst == null) {
            return true;
        }

        if (i == (altura - 1)) {
            return bst.left == null && bst.right == null;
        }

        else if (i > (altura - 1)) {
            return false;
        }

        return isComplete(bst.left, i + 1, altura) && isComplete(bst.right, i + 1, altura);
        
    }

    private int altura(BST bst) {
        if (bst == null) {
            return 0;
        } else {
            int alturaLeft = altura(bst.left);
            int alturaRight = altura(bst.right);

            return alturaLeft < alturaRight ? + 1 : alturaRight + 1;
        }

    }
    
}
