package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;
import java.util.List;

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
			} else if (element > this.data) {
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
			throw new Exception("BST vazia!");
		} else {
			if (this.data == element) {
				return element;
			} else if (element < this.data && this.left != null) {
				return this.left.search(element);
			} else if (element > this.data && this.right != null) {
				return this.right.search(element);
			}
		}
		throw new Exception("A BST não está vazia e o elemento não foi encontrado nela!");
	}
	
	@Override
	public int[] preOrder() {
		ArrayList<Integer> result = new ArrayList<>();
		preOrderRoute(this, result);
		return byArrayListToVector(result);
	}

	private void preOrderRoute(BST bst, ArrayList<Integer> result) {
		if(bst != null) {
			result.add(bst.data);
			preOrderRoute(bst.left,result);
			preOrderRoute(bst.right,result);
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
		int numberNodes = countNodes(this);
		return isComplete(this,0,numberNodes);
	}

	private boolean isComplete(BST bst, int indexNode, int numberNodes) {
		if(bst == null) {
			return true;
		}
		
		if(indexNode>=numberNodes) {
			return false;
		}
		
		return isComplete(bst.left, 2*indexNode+1 ,numberNodes) && isComplete(bst.right, 2*indexNode+2 ,numberNodes);
	}

	private int countNodes(BST bst) {
		if(bst == null) {
			return 0;
		}
		return 1 + countNodes(bst.left) + countNodes(bst.right);
	}
	
	private int[] byArrayListToVector(ArrayList<Integer> list) {
		int vector[] = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			vector[i] = list.get(i);
		}
		return vector;
	}
}
