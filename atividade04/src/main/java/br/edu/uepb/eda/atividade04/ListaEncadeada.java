package br.edu.uepb.eda.atividade04;

public class ListaEncadeada implements ListaEncadeada_IF {

	protected Integer data;
	protected ListaEncadeada next;

	public ListaEncadeada() {
		this.data = null;
		this.next = null;
	}

	@Override
	public boolean isEmpty() {
		if (data == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return 1 + next.size();
	}

	@Override
	public Integer search(Integer element) throws Exception {
		if (isEmpty()) {
			throw new Exception("Elemento não encontrado");
		} else {
			if (data.equals(element)) {
				return element;
			} else {
				return next.search(element);
			}
		}
	}

	@Override
	public void insert(Integer element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new ListaEncadeada();
		} else {
			ListaEncadeada newNode = new ListaEncadeada();
			newNode.data = this.data;
			newNode.next = this.next;
			this.data = element;
			this.next = newNode;
		}
	}

	@Override
	public void remove(Integer element) {
		if (isEmpty()) {

		} else {
			if (data.equals(element)) {
				this.data = next.data;
				this.next = next.next;
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public int[] toArray() {
		int[] result = new int[size()];
		toArrayAux(result, this, 0);
		return result;
	}

	private void toArrayAux(int[] result, ListaEncadeada list, int index) {
		if (!list.isEmpty()) {
			result[index] = list.data;
			toArrayAux(result, list.next, index + 1);
		}
	}

}