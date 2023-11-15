package br.edu.uepb.eda.atividade04;

public class PVTree extends BST {


    private boolean isblack;
    private PVTree parent;
    private PVTree left;
    private PVTree right;

    public PVTree() {
        super();
        this.isblack = true;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    @Override
    public void insert(Integer element) {
        PVTree newNode = new PVTree();
        newNode.data = element;
        newNode.isblack = false;

        auxInsert(this, newNode);

        fixInsertion(newNode);
    }

    private void auxInsert(PVTree tree, PVTree newNode) {
        if (tree.data == null) {
            tree.data = newNode.data;
            tree.left = new PVTree();
            tree.right = new PVTree();
            newNode.parent = tree;
        } else if (newNode.data > tree.data) {
            auxInsert(tree.right, newNode);
        } else {
            auxInsert(tree.left, newNode);
        }
    }

    private void fixInsertion(PVTree node) {
        fixInsertionRecursive(node);
        this.isblack = true; 
    }

    private void fixInsertionRecursive(PVTree node) {
    if (node == null || node.parent == null || node.parent.isblack != false) {
        this.isblack = true;
        return;
    }

    if (node.parent == node.parent.parent.left) {
        PVTree uncle = node.parent.parent.right;

        if (uncle != null && uncle.isblack == false) {
            // Caso 1: O tio é vermelho.
            node.parent.isblack = true;
            uncle.isblack = true;
            node.parent.parent.isblack = false;
            fixInsertionRecursive(node.parent.parent);
        } else {
            // Caso 2: O tio é preto.
            if (node == node.parent.right) {
                node = node.parent;
                rotateLeft(node);
            }

            node.parent.isblack = true;
            node.parent.parent.isblack = false;
            rotateRight(node.parent.parent);
        }
    } else {
        PVTree uncle = node.parent.parent.left;

        if (uncle != null && uncle.isblack == false) {
            // Caso 1: O tio é vermelho.
            node.parent.isblack = true;
            uncle.isblack = true;
            node.parent.parent.isblack = false;
            fixInsertionRecursive(node.parent.parent);
        } else {
            // Caso 2: O tio é preto.
            if (node == node.parent.left) {
                node = node.parent;
                rotateRight(node);
            }

            node.parent.isblack = true;
            node.parent.parent.isblack = false;
            rotateLeft(node.parent.parent);
        }
    }
}

    private void rotateLeft(PVTree node) {
        PVTree rightChild = node.right;
        node.right = rightChild.left;

        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.parent = node.parent;

        if (node.parent == null) {
            this.left = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }

        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rotateRight(PVTree node) {
        PVTree leftChild = node.left;
        node.left = leftChild.right;

        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.parent = node.parent;

        if (node.parent == null) {
            this.left = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }

        leftChild.right = node;
        node.parent = leftChild;
    }
}

