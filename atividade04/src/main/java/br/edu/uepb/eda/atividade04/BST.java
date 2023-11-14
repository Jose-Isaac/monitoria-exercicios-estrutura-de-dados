package  br.edu.uepb.eda.atividade04;
import java.util.ArrayList;
import java.util.List;


public class BST implements BST_IF{

	protected Integer data;
	protected BST esquerda;
	protected BST direita;
	protected BST parametro;



	public BST (Integer data){
		this.data = data;
	}

	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public void insert(Integer element) {
		if(isEmpty()) {
			data = element;
		}else {
			if (element < data) {
				if (esquerda == null) {
					esquerda = new BST(element);
				} else {
					esquerda.insert(element);
				}
			} else if (element > data) {
				if (direita == null) {
					direita = new BST(element);
				} else {
					direita.insert(element);
				}
			}

		}
	}

	@Override
	public Integer search(Integer element) throws Exception {
		if(isEmpty()) {
			return null;
		}else {
			if(data.equals(element)) {
				return element;
			}else if(element < data && esquerda != null) {
				return esquerda.search(element);
			}else if(element>data && direita!=null) {
				return direita.search(element);
			}
		}
		return null;
	}

	@Override
	public Integer[] preOrder() {
		List<Integer> result = new ArrayList<>();
		preOrderaux(this,result);
		return result.toArray(new Integer[0]);
	}

	private void preOrderaux(BST bst, List<Integer> result) {
		if(bst != null) {
			result.add(bst.data);
			preOrderaux(bst.esquerda,result);
			preOrderaux(bst.direita,result);
		}
	}

	@Override
	public Integer[] order() {
		List<Integer> result = new ArrayList<>();
		orderaux(this,result);
		return result.toArray(new Integer[0]);
	}

	private void orderaux(BST bst, List<Integer> result) {
		if(bst != null) {
			orderaux(bst.esquerda,result);
			result.add(bst.data);
			orderaux(bst.direita,result);
		}
	}

	@Override
	public Integer[] postOrder() {
		List<Integer> result = new ArrayList<>();
		postOrderaux(this,result);
		return result.toArray(new Integer[0]);
	}

	private void postOrderaux(BST bst, List<Integer> result) {
		if(bst != null) {
			postOrderaux(bst.esquerda,result);
			postOrderaux(bst.direita,result);
			result.add(bst.data);
		}
	}

	@Override
	public boolean isComplete() {
		int index = 0;
		int contador = contaux(this);
		return isComplete(this, index, contador);
	}

	private boolean isComplete(BST bst, int index, int count) {
		if (bst == null) {
			return true;
		}
		if (index >= count) {
			return false;
		}
		return isComplete(bst.esquerda, 2 * index + 1, count) && isComplete(bst.direita, 2 * index + 2, count);
	}

	private int contaux(BST bst) {
		if (bst == null) {
			return 0;
		}
		return 1 + contaux(bst.esquerda) + contaux(bst.direita);
	}
}