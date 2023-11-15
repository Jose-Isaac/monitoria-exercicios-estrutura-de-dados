package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {
    private TreeNode root;

    @Override
    public void insert(Integer element) {
        root = insertRecursive(root, element);
    }

    private TreeNode insertRecursive(TreeNode root, Integer element) {
        if (root == null) {
            return new TreeNode(element);
        }

        if (element < root.value) {
            root.left = insertRecursive(root.left, element);
        } else if (element > root.value) {
            root.right = insertRecursive(root.right, element);
        }

        return root;
    }

    @Override
    public Integer search(Integer element) throws Exception {
        TreeNode result = searchRecursive(root, element);
        if (result == null) {
            throw new Exception("Elemento não encontrado na árvore");
        }
        return result.value;
    }

    private TreeNode searchRecursive(TreeNode root, Integer element) {
        if (root == null || root.value.equals(element)) {
            return root;
        }

        if (element < root.value) {
            return searchRecursive(root.left, element);
        }

        return searchRecursive(root.right, element);
    }

    @Override
    public int[] preOrder() {
        return preOrderTraversal(root);
    }

    private int[] preOrderTraversal(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        int[] result = new int[getSize(root)];
        preOrderTraversal(root, result, 0);
        return result;
    }

    private int preOrderTraversal(TreeNode root, int[] result, int index) {
        if (root != null) {
            result[index++] = root.value;
            index = preOrderTraversal(root.left, result, index);
            index = preOrderTraversal(root.right, result, index);
        }
        return index;
    }

    @Override
    public int[] order() {
        return inOrderTraversal(root);
    }

    private int[] inOrderTraversal(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        int[] result = new int[getSize(root)];
        inOrderTraversal(root, result, 0);
        return result;
    }

    private int inOrderTraversal(TreeNode root, int[] result, int index) {
        if (root != null) {
            index = inOrderTraversal(root.left, result, index);
            result[index++] = root.value;
            index = inOrderTraversal(root.right, result, index);
        }
        return index;
    }

    @Override
    public int[] postOrder() {
        return postOrderTraversal(root);
    }

    private int[] postOrderTraversal(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        int[] result = new int[getSize(root)];
        postOrderTraversal(root, result, 0);
        return result;
    }

    private int postOrderTraversal(TreeNode root, int[] result, int index) {
        if (root != null) {
            index = postOrderTraversal(root.left, result, index);
            index = postOrderTraversal(root.right, result, index);
            result[index++] = root.value;
        }
        return index;
    }

    @Override
    public boolean isComplete() {
        return isComplete(root, 0, getSize(root));
    }

    private boolean isComplete(TreeNode root, int index, int size) {
        if (root == null) {
            return true;
        }

        if (index >= size) {
            return false;
        }

        return isComplete(root.left, 2 * index + 1, size) && isComplete(root.right, 2 * index + 2, size);
    }

    private int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + getSize(root.left) + getSize(root.right);
    }

    private static class TreeNode {
        private Integer value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
