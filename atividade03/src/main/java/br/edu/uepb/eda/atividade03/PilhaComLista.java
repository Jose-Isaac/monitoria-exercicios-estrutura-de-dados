package atividade03;

public class PilhaComLista implements Pilha_IF {
	
	protected ListaEncadeada pilha = new ListaEncadeada();

	public void push(Integer element) throws Exception {
		if(this.isFull()) {
			throw new Exception("LISTA CHEIA");
		}else {
			pilha.insert(element);
		}
	}

	public Integer pop() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("LISTA VAZIA");
		}else {
			int aux = pilha.valor;
			pilha.remove(pilha.valor);
			return aux;
		}
	}

	public Integer top() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("LISTA VAZIA");
		}else {
			return pilha.valor;
		}
	}

	public boolean isEmpty() {
		return pilha.isEmpty();
	}

	public boolean isFull() {
		if(pilha.size() == 10) {
			return true;
		}else {
			return false;
		}
	}

}
