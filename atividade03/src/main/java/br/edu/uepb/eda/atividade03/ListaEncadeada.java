package br.edu.uepb.eda.atividade03;
public class ListaEncadeada implements ListaEncadeada_IF {

	protected Integer data;
	protected ListaEncadeada next;
	protected Integer head;

	Integer metodohead(){
		while (!isEmpty()) {
			head = next.data;}
		return data;
	}

	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public ListaEncadeada getNext() {
		return next;
	}
	public void setNext(ListaEncadeada next) {
		this.next = next;
	}
	@Override
	public boolean isEmpty() {
		if (data == null && next == null) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}else {
			return 1 + next.size();
		}

	}
	@Override
	public Integer search(Integer element) {
		if (isEmpty()) throw new Exception("Elemento não encontrado na lista.");
		 else {
			if (data.equals(element)) {
				return data;
			} else {
				return next.search(element);


			}}

	}
	@Override
	public void insert(Integer element) {
		if (isEmpty()) {
			data = element;
			next = new ListaEncadeada();
		} else {
			ListaEncadeada newNode = new ListaEncadeada();
			newNode.setData(data);
			newNode.setNext(next);
			data = element;
			next = newNode;
		}
	}
	@Override
	public void remove(Integer element) {
		if(isEmpty()) {

		}else {
			if (data.equals(element)) {
				data = next.data;
				next = next.next;
			}else {
				next.remove(element);
			}
		}
	}
	@Override
	public Integer[] toArray() {
		Integer[] result = new Integer[size()];
		toArrayAux(result, this, 0);
		return result;
	}

	private int toArrayAux(Integer[] result, ListaEncadeada listaEncadeada, int index) {
		if (!listaEncadeada.isEmpty()) {
			result[index] = listaEncadeada.data;
			return toArrayAux(result, listaEncadeada.next, index + 1);
		}
		return index;
	}
}
