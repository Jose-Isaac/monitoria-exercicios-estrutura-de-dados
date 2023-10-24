package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
	Integer data;
	ListaEncadeada proximo;

	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		if (isEmpty()) return 0;
		return 1 + proximo.size();
	}

	@Override
	public Integer search(Integer element) throws Exception {
		if (isEmpty()) throw new Exception("Elemento não encontrado na lista.");
		
		if (data.equals(element)) return data;
		
		else return proximo.search(element);
	}

	@Override
	public void insert(Integer element) {
		if (isEmpty()) {
			data = element;
			proximo = new ListaEncadeada();
		}
		
		else {
			ListaEncadeada noAux = new ListaEncadeada();
			noAux.data = data;
			noAux.proximo = proximo;
			
			data = element;
			proximo = noAux;
		}
	}

	@Override
	public void remove(Integer element) {
		if (!isEmpty()) {
			if (data.equals(element)) {
				data = proximo.data;
				proximo = proximo.proximo;
			} else {
				proximo.remove(element);
			}
		}
	}

	@Override
	public int[] toArray() {
		int[] array = new Integer[size()];
		toArrayRecursive(this, array, 0);
		return array;
	}

	protected void toArrayRecursive(ListaEncadeada current, int[] array, int i) {
		if (!current.isEmpty()) {
			array[i] = current.data;
			toArrayRecursive(current.proximo, array, i + 1);
		}
	}

}