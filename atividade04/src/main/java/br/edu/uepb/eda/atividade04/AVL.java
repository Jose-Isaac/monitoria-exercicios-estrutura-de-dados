package br.edu.uepb.eda.atividade04;


public class AVL extends BST {

    protected AVL left;
    protected AVL right;
    private int height;

    public AVL() {
        super();
        this.height = 0;
    }

    @Override
    public void insert(Integer element) {
        auxInsertAVL(this, element);
        updateHeight(this);
    }

    private void auxInsertAVL(AVL tree, Integer element){
        
        if(tree.data == null) {
            tree.data = element;
            tree.left = new AVL();
            tree.right = new AVL();
        }
        
        else if(element > tree.data) auxInsertAVL(tree.right, element);
        else auxInsertAVL(tree.left, element);
        updateHeight(this);
        balance(this);
    }

    private void updateHeight(AVL tree) {
        if (tree.data != null) {
            tree.height = 1 + Math.max(height(tree.left), height(tree.right));
        } else {
            tree.height = 0;
        }
    }

    private int height(AVL tree) {
        return (tree != null) ? tree.height : -1;
    }

    private int balanceFactor(AVL tree) {
        return height(tree.left) - height(tree.right);
    }

    private void rotateRight(AVL tree) {
        AVL newRoot = tree.left;
        tree.left = newRoot.right;
        newRoot.right = tree;
        updateHeight(tree);
        updateHeight(newRoot);
        tree = newRoot;
    }

    private void rotateLeft(AVL tree) {
        AVL newRoot = tree.right;
        tree.right = newRoot.left;
        newRoot.left = tree;
        updateHeight(tree);
        updateHeight(newRoot);
        tree = newRoot;
    }

    private void balance(AVL tree) {
        int balance = balanceFactor(tree);

        if (balance > 1) {
            if (height(tree.left.left) >= height(tree.left.right)) {
                rotateRight(tree);
            } else {
                rotateLeft(tree.left);
                rotateRight(tree);
            }
        } else if (balance < -1) {
            if (height(tree.right.right) >= height(tree.right.left)) {
                rotateLeft(tree);
            } else {
                rotateRight(tree.right);
                rotateLeft(tree);
            }
        }

     
    }
}
