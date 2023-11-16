package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {

    protected Node_BST root;

    public BST () { this.root = null; }

    @Override
    public void insert (Integer element) {
        this.root = insert_recursive(this.root, element);
    }
    public Node_BST insert_recursive (Node_BST node, int data) {
        if (node == null) {
            node = new Node_BST(data);
            return node;
        } else if (data < node.data) {
            node.left = insert_recursive(node.left, data);
        } else {
            node.right = insert_recursive(node.right, data);
        }
        return node;
    }

    @Override
    public Integer search(Integer element) throws Exception {
        Integer result = search_recursive(this.root, element);
        if (result == null) {
            throw new Exception ("Não está na árvore");
        } return result;
    }
    public Integer search_recursive (Node_BST node, Integer data) {
        if (node == null) {
            return null;
        } else if (node.data == data) {
            return data;
        } else if (data < node.data) {
            return search_recursive(node.left,data);
        } else {
            return search_recursive(node.right,data);
        }
    }

    @Override
    public int[] preOrder() {
        int[] pre_order = new int [count_nos(root)];
        pre_order(root, pre_order, 0);
        return pre_order;
    }
    public int pre_order (Node_BST node, int[] list, int i) { //RED
        if (node != null) {
            list[i++] = node.data;
            pre_order(node.left, list, i);
            pre_order(node.right, list, i+count_nos(node.left));
        } return i ;
    }

    @Override
    public int[] order() {
        int[] order = new int [count_nos(root)];
        order(root, order, 0);
        return order;
    }
    public int order (Node_BST node, int[] list, int i) { //ERD
        if (node != null) {
            i = order(node.left, list, i);
            list[i++] = node.data;
            return order(node.right, list, i);
        } return i;
    }

    @Override
    public int[] postOrder() {
        int[] post_order = new int [count_nos(root)];
        post_order(root, post_order, 0);
        return post_order;
    }
    public int post_order (Node_BST node, int[] list, int i) { //EDR
        if (node != null) {
            i = post_order(node.left, list, i);
            i = post_order(node.right, list, i);
            list[i++] = node.data;
        } return i;
    }

    @Override
    public boolean isComplete() {
        int nos = (int) Math.pow(2, altura(root)+1) - 1; // 2^(h+1)-1
        if (count_nos(root) == nos) {
            return true;
        } return false;
    }

    public int count_nos (Node_BST node) {
        if (node == null) {
            return 0;
        } return 1 + count_nos(node.left) + count_nos(node.right);
    }

    public int altura (Node_BST node) {
        if (node == null || node.left == null && node.right == null) {
            return 0; // inicia do 0
        } else {
            int h_left = altura(node.left);
            int h_right = altura(node.right);

            if (h_left > h_right) {
                return h_left + 1;
            } else {
                return h_right + 1;
            }
        }
    }
}
