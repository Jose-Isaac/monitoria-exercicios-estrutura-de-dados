package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
	final private int tamanho = 10;
    private ListaEncadeada elementos;
    
	public PilhaComLista() {
		elementos = new ListaEncadeada();
	}
    
	@Override
	public void push(Integer element) throws Exception {
		if (isFull()) throw new Exception("A pilha está cheia.");
		
		elementos.insert(element);
	}

	@Override
	public Integer pop() throws Exception {
		if (isEmpty()) throw new Exception("A pilha está vazia.");
		
		Integer topRemovido = top();
		elementos.remove(topRemovido);
        return topRemovido;
	}

	@Override
	public Integer top() throws Exception {
		return elementos.data;
	}

	@Override
	public boolean isEmpty() {
		return elementos.isEmpty();
	}

	@Override
	public boolean isFull() {
		return elementos.size() == tamanho;
	}
}