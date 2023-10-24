package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
	
	private ListaEncadeada lista;
	private int maxElementos = 10;
	
	public PilhaComLista() {
		this.lista = new ListaEncadeada();
	}
	@Override
	public void push(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("A pilha esta cheia.");
		}lista.insert(element);
	}

	@Override
	public Integer pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("A pilha esta vazia,nao da para remover.");
		}
		Integer topo = top();
		lista.remove(topo);
		return topo;
	}

	@Override
	public Integer top() throws Exception {
	    if (isEmpty()) {
	        throw new Exception("A pilha está vazia.");
	    }
	    return lista.data;
	}


	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}

	@Override
	public boolean isFull() {
		return lista.size() >= maxElementos;
	}

    
}
