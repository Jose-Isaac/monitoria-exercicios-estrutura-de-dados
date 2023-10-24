package atividade03;

public class PilhaComLista implements Pilha_IF {

	protected ListaEncadeada l;

	public PilhaComLista() {
		this.l = new ListaEncadeada();
	}

	@Override
	public void push(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("Pilha cheia.");
		} else {
			l.insert(element);
		}
	}

	@Override
	public Integer pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pilha vazia");
		} else {
			int removed = l.data;
			l.remove(removed);
			return removed;
		}
	}

	@Override
	public Integer top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pilha vazia.");
		} else {
			return l.data;
		}
	}

	@Override
	public boolean isEmpty() {
		if (l.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (l.size() == 10) {
			return true;
		} else {
			return false;
		}
	}

}
