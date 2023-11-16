package atividade04;



public class BST implements BST_IF {
    private NodeBST root;

    public void insert(Integer element) {
        if (root == null) {
            root = new NodeBST(element);
        } else {
            insertRecursivo(root, element);
        }
    }

    private void insertRecursivo(NodeBST node, int element) {
        if (element < node.getData()) {
            if (node.getLeft() == null) {
                node.setLeft(new NodeBST(element));
            } else {
                insertRecursivo(node.getLeft(), element);
            }
        } else if (element > node.getData()) {
            if (node.getRight() == null) {
                node.setRight(new NodeBST(element));
            } else {
                insertRecursivo(node.getRight(), element);
            }
        }
    }

    public int search(Integer element) throws Exception {
        NodeBST node = searchRecursive(root, element);
        if (node != null) {
            return node.getData();
        } else {
            throw new Exception("Elemento não encontrado na árvore.");
        }
    }

    private NodeBST searchRecursive(NodeBST node, int element) {
        if (node == null || node.getData() == element) {
            return node;
        }
        if (element < node.getData()) {
            return searchRecursive(node.getLeft(), element);
        }
        return searchRecursive(node.getRight(), element);
    }

    public int[] preOrder() {
        int[] result = new int[countNodes(root)];
        preOrderRecursive(root, result, 0);
        return result;
    }

    private int preOrderRecursive(NodeBST node, int[] result, int index) {
        if (node != null) {
            result[index] = node.getData();
            index++;
            index = preOrderRecursive(node.getLeft(), result, index);
            index = preOrderRecursive(node.getRight(), result, index);
        }
        return index;
    }

    public int[] order() {
        int[] result = new int[countNodes(root)];
        orderRecursive(root, result, 0);
        return result;
    }

    private int orderRecursive(NodeBST node, int[] result, int index) {
        if (node != null) {
            index = orderRecursive(node.getLeft(), result, index);
            result[index] = node.getData();
            index++;
            index = orderRecursive(node.getRight(), result, index);
        }
        return index;
    }

    public int[] postOrder() {
        int[] result = new int[countNodes(root)];
        postOrderRecursive(root, result, 0);
        return result;
    }

    private int postOrderRecursive(NodeBST node, int[] result, int index) {
        if (node != null) {
            index = postOrderRecursive(node.getLeft(), result, index);
            index = postOrderRecursive(node.getRight(), result, index);
            result[index] = node.getData();
            index++;
        }
        return index;
    }

    private int countNodes(NodeBST node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }

    public boolean isComplete() {
        int totalNodes = countNodes(root);
        int index = 0;
        return isCompleteRecursive(root, index, totalNodes);
    }

    private boolean isCompleteRecursive(NodeBST node, int index, int totalNodes) {
        if (node == null) {
            return true;
        }

        if (index >= totalNodes) {
            return false;
        }

        return isCompleteRecursive(node.getLeft(), 2 * index + 1, totalNodes)
                && isCompleteRecursive(node.getRight(), 2 * index + 2, totalNodes);
    }

}
