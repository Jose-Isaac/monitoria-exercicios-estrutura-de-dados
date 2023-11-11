package atividade04;
import java.util.ArrayList;
import java.util.List;


public class BST implements BST_IF {
	protected Integer data;
	protected BST esquerda;
	protected BST direita;
	protected BST parametro;
	
	BST (){
		
	}
	
	BST (Integer data){
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
		preOrderTravessia(this,result);
		return result.toArray(new Integer[0]);
	}

	private void preOrderTravessia(BST bst, List<Integer> result) {
		if(bst != null) {
			result.add(bst.data);
			preOrderTravessia(bst.esquerda,result);
			preOrderTravessia(bst.direita,result);
		}
	}

	@Override
	public Integer[] order() {
		List<Integer> result = new ArrayList<>();
		orderTravessia(this,result);
		return result.toArray(new Integer[0]);
	}

	private void orderTravessia(BST bst, List<Integer> result) {
		if(bst != null) {
			orderTravessia(bst.esquerda,result);
			result.add(bst.data);
			orderTravessia(bst.direita,result);
		}
	}

	@Override
	public Integer[] postOrder() {
		List<Integer> result = new ArrayList<>();
		postOrderTravessia(this,result);
		return result.toArray(new Integer[0]);
	}

	private void postOrderTravessia(BST bst, List<Integer> result) {
		if(bst != null) {
			postOrderTravessia(bst.esquerda,result);
			postOrderTravessia(bst.direita,result);
			result.add(bst.data);
		}
	}

    @Override
    public boolean isComplete() {
        int index = 0;
        int count = countNo(this);
        return isComplete(this, index, count);
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

    private int countNo(BST bst) {
        if (bst == null) {
            return 0;
        }
        return 1 + countNo(bst.esquerda) + countNo(bst.direita);
    }
}