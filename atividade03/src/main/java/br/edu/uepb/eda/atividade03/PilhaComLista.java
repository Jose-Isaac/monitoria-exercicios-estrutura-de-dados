package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
	private ListaEncadeada lista;
	private int size;
	private static final int tamanho = 10;

	public PilhaComLista() {
		lista = new ListaEncadeada();
		size = 0;
	}

	public void push(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("Pilha cheia");
		}
		lista.insert(element);
		size++;
	}

	public int pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pilha vazia");
		}
		int topElement = lista.toArray()[0];
		lista.remove(topElement);
		size--;
		return topElement;
	}

	public int top() throws Exception {
		if (isEmpty()) {
			throw new Exception("Pilha vazia");
		}
		return lista.toArray()[0];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == tamanho;
	}
}