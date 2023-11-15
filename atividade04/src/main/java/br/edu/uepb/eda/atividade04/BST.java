package br.edu.uepb.eda.atividade04;
import java.util.ArrayList;
import java.util.List;

public class BST implements BST_IF {

    private Integer key;
    private BST left, right;

    public BST(){
    }
    public BST(Integer key) {
        this.key = key;
        this.left = this.right = null;
    }

    public boolean isNill() {
        return key == null && left == null && right == null;
    }

    @Override
    public void insert(Integer element) {
        insertRec(this, element);
    }

    private void insertRec(BST root, Integer key) {
        if (root.isNill()) {
            root.key = key;
            root.left = new BST(null);
            root.right = new BST(null);
        } else if (key < root.key) {
            insertRec(root.left, key);
        } else if (key > root.key) {
            insertRec(root.right, key);
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        BST result = searchRec(this, element);
        if (result != null && !result.isNill()) {
            return result.key;
        } else {
            throw new Exception("Element not found");
        }
    }

    private BST searchRec(BST node, Integer key) {
        if (node.isNill() || key.equals(node.key)) {
            return node;
        }

        if (key < node.key) {
            return searchRec(node.left, key);
        } else {
            return searchRec(node.right, key);
        }
    }

    @Override
    public Integer[] preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(this, result);
        
        return result.toArray(new Integer[0]);
    }

    private void preOrderTraversal(BST node, List<Integer> result) {
        if (!node.isNill()) {
            result.add(node.key);
            preOrderTraversal(node.left, result);
            preOrderTraversal(node.right, result);
        }
    }

    @Override
    public Integer[] order() {
        List<Integer> result = new ArrayList<>();
        orderTraversal(this, result);
        
        return result.toArray(new Integer[0]);
    }

    private void orderTraversal(BST node, List<Integer> result) {
        if (!node.isNill()) {
            orderTraversal(node.left, result);
            result.add(node.key);
            orderTraversal(node.right, result);
        }
    }

    @Override
    public Integer[] postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(this, result);
        
        return result.toArray(new Integer[0]);
    }

    private void postOrderTraversal(BST node, List<Integer> result) {
        if (!node.isNill()) {
            postOrderTraversal(node.left, result);
            postOrderTraversal(node.right, result);
            result.add(node.key);
        }
    }

    @Override
    public boolean isComplete() {
        return isCompleteRec(this, 0, countNodes(this));
    }

    private int countNodes(BST node) {
        if (node.isNill()) {
            return 0;
        } else {
            return 1 + countNodes(node.left) + countNodes(node.right);
        }
    }

    private boolean isCompleteRec(BST node, int index, int totalNodes) {
        if (node.isNill()) {
            return true;
        }
        if (index >= totalNodes) {
            return false;
        }
        return isCompleteRec(node.left, 2 * index + 1, totalNodes)
                && isCompleteRec(node.right, 2 * index + 2, totalNodes);
    }
    
}
