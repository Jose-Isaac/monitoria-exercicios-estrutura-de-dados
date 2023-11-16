package br.edu.uepb.eda.atividade04;
public class BST implements BST_IF {
    private Node root;
	
	
	@Override
	public void insert(Integer element) {
		  root = insertRec(root, element);
		  

	}
	private Node insertRec(Node root, Integer element) {
        if (root == null) {
            root = new Node(element);
            return root;
        }

        if (element < root.key) {
            root.left = insertRec(root.left, element);
        } else if (element > root.key) {
            root.right = insertRec(root.right, element);
        }

        return root;
    }

	@Override
	public Integer search(Integer element) throws Exception {
		return searchRec(root, element);
	}
	
	private Integer searchRec(Node root, Integer element) throws Exception {
	    if (root == null) {
	        throw new Exception("Element not found in the BST.");
	    }

	    if (element.equals(root.key)) {
	        return root.key;
	    }

	    if (element < root.key) {
	        return searchRec(root.left, element);
	    } else {
	        return searchRec(root.right, element);
	    }
	}
	
	@Override
	public int[] preOrder() {
	    int[] result = new int[countNodes(root)];
	    preOrderRec(root, result, new int[]{0});
	    return result;
	}

	private void preOrderRec(Node node, int[] result, int[] index) {
	    if (node != null) {
	        result[index[0]++] = node.key;
	        preOrderRec(node.left, result, index);
	        preOrderRec(node.right, result, index);
	    }
	}
	
	@Override
	public int[] order() {
	    int[] result = new int[countNodes(root)];
	    inOrderRec(root, result, new int[]{0});
	    return result;
	}

	private void inOrderRec(Node node, int[] result, int[] index) {
	    if (node != null) {
	        inOrderRec(node.left, result, index);
	        result[index[0]++] = node.key;
	        inOrderRec(node.right, result, index);
	    }
	}
	
	
	@Override
	public int[] postOrder() {
	    int[] result = new int[countNodes(root)];
	    postOrderRec(root, result, new int[]{0});
	    return result;
	}

	private void postOrderRec(Node node, int[] result, int[] index) {
	    if (node != null) {
	        postOrderRec(node.left, result, index);
	        postOrderRec(node.right, result, index);
	        result[index[0]++] = node.key;
	    }
	}
	
	@Override
	public boolean isComplete() {
	    return isCompleteRec(root, 0, countNodes(root));
	}

	private int countNodes(Node node) {
	    if (node == null) {
	        return 0;
	    }
	    return 1 + countNodes(node.left) + countNodes(node.right);
	}

	private boolean isCompleteRec(Node node, int index, int nodeCount) {
	    if (node == null) {
	        return true;
	    }

	    if (index >= nodeCount) {
	        return false;
	    }

	    return isCompleteRec(node.left, 2 * index + 1, nodeCount) &&
	           isCompleteRec(node.right, 2 * index + 2, nodeCount);
	}
    
}
