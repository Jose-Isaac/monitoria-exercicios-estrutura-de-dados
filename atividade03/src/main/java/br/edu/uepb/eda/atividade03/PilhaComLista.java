package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
	ListaEncadeada  pilha = new ListaEncadeada();
	int posPilha;
	@Override
	public void push(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("A pilha está cheia.");
		} else {

			pilha.insert(element);
		}
	}

	@Override
	public Integer pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("A pilha está vazia.");
		}
		int pilhatopvalor = pilha.data;
		pilha.remove(pilhatopvalor);
		return pilhatopvalor;
	}

	@Override
	public Integer top() throws Exception {
		if (isEmpty()) {
			throw new Exception("A pilha está vazia.");
		}
		return pilha.data;
	}
	@Override
	public boolean isEmpty() {
		if(pilha.isEmpty()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isFull() {
		if(pilha.size() < 10) {
			return false;
		}
		return true;
	}
}