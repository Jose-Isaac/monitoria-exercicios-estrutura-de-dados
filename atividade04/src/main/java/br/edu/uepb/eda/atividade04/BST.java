package br.edu.uepb.eda.atividade04;
import java.util.ArrayList;
import java.util.List;


public class BST implements BST_IF{

	protected Integer data;
	protected BST esquerda;
	protected BST direita;
	protected BST pai;


	public BST (Integer dado){
		this.data = dado;
		this.esquerda=null;
		this.direita=null;
		this.pai=null;
	}
	public BST (){
		this.data = null;
		this.esquerda=null;
		this.direita=null;
		this.pai=null;
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
                    esquerda = new BST();
                } 
				esquerda.insert(element);
                
            } else if (element > data) {
                if (direita == null) {
                    direita = new BST();
                } 
                direita.insert(element);
                
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
        int contador = contaux(this);
        return isCompleteAux(this, 0, contador);
    }

    private boolean isCompleteAux(BST bst, int index, int count) {
        if (bst == null) {
            return true;
        }
        if (index >= count) {
            return false;
        }
        return isCompleteAux(bst.esquerda, 2 * index + 1, count) && isCompleteAux(bst.direita, 2 * index + 2, count);
    }

    private int contaux(BST bst) {
        if (bst == null) {
            return 0;
        }
        return 1 + contaux(bst.esquerda) + contaux(bst.direita);
    }
}
