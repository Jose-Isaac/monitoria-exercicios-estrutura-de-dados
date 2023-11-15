package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;

public class BST implements BST_IF {
	protected Integer data;
	protected BST left;
	protected BST right;
	protected BST parent;
	
	public BST() {
		this.data = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	public boolean isEmpty() {
		return this.data==null;
	}

	@Override
	public void insert(Integer element) {
		if (isEmpty()) {
			this.data = element;
		} else {
			if(element < this.data) {
				if (this.left == null) {
					this.left = new BST();
					this.left.insert(element);
					this.left.parent = this;
				} else {
					this.left.insert(element);
				}
			} else {
				if (this.right == null) {
					this.right = new BST();
					this.right.insert(element);
					this.right.parent = this;
				} else {
					this.right.insert(element);
				}
			}
		}
	}

	@Override
	public Integer search(Integer element) throws Exception {
		if (isEmpty()) {
			throw new Exception("BST vazia.");
		} else {
			if (this.data == element) {
				return element;
			} else if (element < this.data && this.left != null) {
				return this.left.search(element);
			} else if (element > this.data && this.right != null) {
				return this.right.search(element);
			}
		}
		throw new Exception("Valor não encontrado!");
	}
	
	@Override
	public int[] preOrder() {
		ArrayList<Integer> result = new ArrayList<>();
		preOrder_route(this, result);
		return byArrayListToVector(result);
	}

	private void preOrder_route(BST bst, ArrayList<Integer> result) {
		if(bst != null) {
			result.add(bst.data);
			preOrder_route(bst.left,result);
			preOrder_route(bst.right,result);
		}
	}

	@Override
	public int[] order() {
		ArrayList<Integer> result = new ArrayList<>();
		orderRoute(this, result);
		return byArrayListToVector(result);
	}
	
	private void orderRoute(BST bst, ArrayList<Integer> result) {
		if(bst != null) {
			orderRoute(bst.left,result);
			result.add(bst.data);
			orderRoute(bst.right,result);
		}
	}

	@Override
	public int[] postOrder() {
		ArrayList<Integer> result = new ArrayList<>();
		postOrderRoute(this, result);
		return byArrayListToVector(result);
	}
	
	private void postOrderRoute(BST bst, ArrayList<Integer> result) {
		if(bst != null) {
			postOrderRoute(bst.left,result);
			postOrderRoute(bst.right,result);
			result.add(bst.data);
		}
	}
	
	@Override
	public boolean isComplete() {
		return isComplete_recursive(this, 0, heightMin(this));
	}

	private int heightMin(BST bst) {
		if (bst == null) {
			return 0;
		} else {
			int leftHeight = heightMin(bst.left);
			int rightHeight = heightMin(bst.right);

			if (leftHeight < rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}

	private boolean isComplete_recursive(BST bst, int index, int heightMin) {
		if (bst == null && index == 0)
			return false;

		if (bst == null)
			return true;

		if (index == (heightMin - 1))
			return bst.left == null && bst.right == null;

		else if (index > (heightMin - 1))
			return false;

		return isComplete_recursive(bst.left, index + 1, heightMin) && isComplete_recursive(bst.right, index + 1, heightMin);
	}
	
	private int[] byArrayListToVector(ArrayList<Integer> list) {
		int vector[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			vector[i] = list.get(i);
		}
		return vector;
	}
}
