package atividade04;

public class BST implements BST_IF {

	public Node root;

	public class Node {
		Integer data;
		Node left, right;

		public Node(Integer element) {
			data = element;
			left = right = null;
		}
	}

	@Override
	public void insert(Integer element) {
		root = insertRecursive(root, element);
	}

	private Node insertRecursive(Node root, Integer element) {
		if (root == null) {
			root = new Node(element);
			return root;
		}

		if (element < root.data) {
			root.left = insertRecursive(root.left, element);
		} else if (element > root.data) {
			root.right = insertRecursive(root.right, element);
		}

		return root;
	}

	@Override
	public Integer search(Integer element) throws Exception {
		Integer result = searchRecursive(root, element);
		if (result == null) {
			throw new Exception("Elemento não encontrado na BST.");
		}
		return result;
	}

	private Integer searchRecursive(Node root, Integer element) {
		if (root == null || root.data.equals(element)) {
			return (root != null) ? root.data : null;
		}

		if (element < root.data) {
			return searchRecursive(root.left, element);
		}
		return searchRecursive(root.right, element);
	}

	@Override
	public int[] preOrder() {
		int[] results = new int[size(root)];
		preOrderRecursive(root, results, new Index());
		return results;
	}

	private void preOrderRecursive(Node root, int[] result, Index i) {
		if (root != null) {
			result[i.value++] = root.data;
			preOrderRecursive(root.left, result, i);
			preOrderRecursive(root.right, result, i);
		}
	}

	@Override
	public int[] order() {
		int[] results = new int[size(root)];
		orderRecursive(root, results, new Index());
		return results;
	}

	private void orderRecursive(Node root, int[] result, Index i) {
		if (root != null) {
			orderRecursive(root.left, result, i);
			result[i.value++] = root.data;
			orderRecursive(root.right, result, i);
		}
	}

	@Override
	public int[] postOrder() {
		int[] results = new int[size(root)];
		postOrderRecursive(root, results, new Index());
		return results;
	}

	private void postOrderRecursive(Node root, int[] result, Index i) {
		if (root != null) {
			postOrderRecursive(root.left, result, i);
			postOrderRecursive(root.right, result, i);
			result[i.value++] = root.data;
		}
	}

	@Override
	public boolean isComplete() {
		int i = 0;
		return isCompleteRecursive(root, i, size(root));
	}

	private boolean isCompleteRecursive(Node root, int index, int size) {
		if (root == null) {
			return true;
		}

		if (index >= size) {
			return false;
		}

		return (isCompleteRecursive(root.left, 2 * index + 1, size) &&
				isCompleteRecursive(root.right, 2 * index + 2, size));
	}

	public int size(Node size) {
		if (size == null) {
			return 0;
		}
		return 1 + size(size.left) + size(size.right);
	}

	public int height(Node root) {
		if (root != null) {
			int hRight, hLeft = 0;
			hLeft = height(root.left);
			hRight = height(root.right);

			if (hRight > hLeft)
				return hRight + 1;

			return hLeft + 1;
		}
		return 0;
	}

	public static class Index {
		int value;
	}
}
