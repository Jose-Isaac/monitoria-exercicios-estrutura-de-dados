package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {
	private class Node {
		int key;
		Node left, right;

		Node(int key) {
			this.key = key;
			left = right = null;
		}
	}

	private Node root;

	public BST() {
		root = null;
	}

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
		int result = searchRec(root, element);

		if (result == -1)
			throw new Exception("Element not found in the BST");

		return result;
	}

	private Integer searchRec(Node root, int element) {
		if (root == null)
			return -1;

		if (root.key == element)
			return root.key;

		if (element < root.key)
			return searchRec(root.left, element);

		return searchRec(root.right, element);
	}

	private Integer[] reverse(Integer[] integers) {
		Integer[] newList = new Integer[integers.length];
		for (int i = integers.length - 1; i >= 0; i--) {
			newList[i] = integers[(integers.length - 1) - i];
		}
		return newList;
	}

	@Override
	public Integer[] preOrder() {
		ListaEncadeada list = new ListaEncadeada();
		preOrderRec(root, list);
		return reverse(list.toArray());
	}

	private void preOrderRec(Node root, ListaEncadeada list) {
		if (root != null) {
			list.insert(root.key);
			preOrderRec(root.left, list);
			preOrderRec(root.right, list);
		}
	}

	@Override
	public Integer[] order() {
		ListaEncadeada list = new ListaEncadeada();
		inOrderRec(root, list);
		return reverse(list.toArray());
	}

	private void inOrderRec(Node root, ListaEncadeada list) {
		if (root != null) {
			inOrderRec(root.left, list);
			list.insert(root.key);
			inOrderRec(root.right, list);
		}
	}

	@Override
	public Integer[] postOrder() {
		ListaEncadeada list = new ListaEncadeada();
		postOrderRec(root, list);
		return reverse(list.toArray());
	}

	private void postOrderRec(Node root, ListaEncadeada list) {
		if (root != null) {
			postOrderRec(root.left, list);
			postOrderRec(root.right, list);
			list.insert(root.key);
		}
	}

	@Override
	public boolean isComplete() {
		return isCompleteRec(root, 0, heightMin(root));
	}

	private Integer heightMin(Node root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = heightMin(root.left);
			int rightHeight = heightMin(root.right);

			if (leftHeight < rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}

	private boolean isCompleteRec(Node root, int index, int heightMin) {
		if (root == null && index == 0)
			return false;

		if (root == null)
			return true;

		if (index == (heightMin - 1))
			return root.left == null && root.right == null;

		else if (index > (heightMin - 1))
			return false;

		return isCompleteRec(root.left, index + 1, heightMin) && isCompleteRec(root.right, index + 1, heightMin);
	}

}
