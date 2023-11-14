package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {
    private class Node{
        int key;
        Node left, right;
    
        Node(int key){
            this.key = key;
            left = null;
            right = null;
        }
    }
    private Node root;   

    public BST() {
		root = null;
	}
    
    private int getSize() {
		return getSizeAux(root);
	}

	private int getSizeAux(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + getSizeAux(root.left) + getSizeAux(root.right);
	}

	@Override
	public void insert(Integer element) {
		root = insertAux(root, element);
	}

	private Node insertAux(Node root, int element) {
		if (root == null) {
			root = new Node(element);
			return root;
		}

		if (element < root.key) {
			root.left = insertAux(root.left, element);
		} else if (element > root.key) {
			root.right = insertAux(root.right, element);
		}

		return root;
	}

	@Override
	public Integer search(Integer element) throws Exception {
		return searchAux(root, element);
	}

	private int searchAux(Node root, int element) throws Exception {
		if (root == null) {
			throw new Exception("Elemento não encontrado na árvore.");
		}

		if (element == root.key) {
			return element;
		}

		if (element < root.key) {
			return searchAux(root.left, element);
		}

		return searchAux(root.right, element);
	}

	@Override
	public int[] preOrder() {
		int[] result = new int[getSize()];
		preOrderAux(root, result, 0);
		return result;
	}

	private int preOrderAux(Node root, int[] result, int index) {
		if (root != null) {
			result[index] = root.key;
			index++;
			index = preOrderAux(root.left, result, index);
			index = preOrderAux(root.right, result, index);
		}
		return index;
	}

	@Override
	public int[] order() {
		int[] result = new int[getSize()];
		orderAux(root, result, 0);
		return result;
	}

	private int orderAux(Node root, int[] result, int index) {
		if (root != null) {
			index = orderAux(root.left, result, index);
			result[index] = root.key;
			index++;
			index = orderAux(root.right, result, index);
		}
		return index;
	}

	@Override
	public int[] postOrder() {
		int[] result = new int[getSize()];
		postOrderAux(root, result, 0);
		return result;
	}

	private int postOrderAux(Node root, int[] result, int index) {
		if (root != null) {
			index = postOrderAux(root.left, result, index);
			index = postOrderAux(root.right, result, index);
			result[index] = root.key;
			index++;
		}
		return index;
	}

    @Override
    public boolean isComplete(){
        return isCompleteAux(root);
    }

    public boolean isCompleteAux(Node root){
        if(root == null) return true; 
        else if(root.left == null && root.right == null ) return true;
        else if((root.left != null) && (root.right != null)){
            return (isCompleteAux(root.left) && isCompleteAux(root.right));
        }  
        return false;
    }    
}