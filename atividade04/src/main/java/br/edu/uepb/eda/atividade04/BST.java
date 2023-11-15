package br.edu.uepb.eda.atividade04;
import java.util.ArrayList;
import java.util.List;


public class BST implements BST_IF{

	protected Integer data;
	protected BST esquerda;
	protected BST direita;
	protected BST pai;
	
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
		if(isEmpty()) {
			throw new Exception("BST vazia!");
		}else {
			if(data.equals(element)) {
				return element;
			}else if(element < data && esquerda != null) {
				return esquerda.search(element);
			}else if(element>data && direita!=null) {
				return direita.search(element);
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
        return isCompleteAux(this, 0, contaux(this));
    }

	private int contaux(BST bst) {
		if (bst == null) {
			return 0;
		} else {
			int esquerdacont = contaux(bst.esquerda);
			int direitacont = contaux(bst.direita);

			if (esquerdacont < direitacont)
				return esquerdacont + 1;
			else
				return direitacont + 1;
		}
	}

    private boolean isCompleteAux(BST bst, int index, int count) {
        if (bst == null && index == 0)
			return false;

		if (bst == null)
			return true;

		if (index == (count - 1))
			return bst.esquerda == null && bst.direita == null;

		else if (index > (count - 1))
			return false;

		return isCompleteAux(bst.esquerda, index + 1, count) && isCompleteAux(bst.direita, index + 1, count);
	}
}
