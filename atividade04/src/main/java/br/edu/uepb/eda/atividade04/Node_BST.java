package br.edu.uepb.eda.atividade04;

public class Node_BST {

    protected Integer data;
    protected Node_BST left;
    protected Node_BST right;

    Node_BST () {}

    Node_BST (Integer data) {
        this.data = data;
        this.left = this.right = null;
    }

    public Integer getData() {
        return data;
    } public void setData(Integer data) {
        this.data = data;
    }

    public Node_BST getLeft() {
        return left;
    } public void setLeft(Node_BST left) {
        this.left = left;
    }

    public Node_BST getRight() {
        return right;
    } public void setRight(Node_BST right) {
        this.right = right;
    }
}
