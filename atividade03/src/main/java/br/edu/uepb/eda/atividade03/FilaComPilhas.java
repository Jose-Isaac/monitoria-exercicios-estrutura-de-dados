package atividade03;

public class FilaComPilhas implements Fila_IF {
	Pilha_IF entrada;
	Pilha_IF saida;
	
	public FilaComPilhas() {
		entrada = new PilhaComLista();
		saida = new PilhaComLista();
	}
	
	@Override
	public void enqueue(Integer element) throws Exception {
		if (isFull()) throw new Exception("A fila está cheia.");
		while (!saida.isEmpty()) {
			entrada.push(saida.pop());
		}
		saida.push(element);
		while(!entrada.isEmpty()) {
			saida.push(entrada.pop());
		}
	}

	@Override
	public Integer dequeue() throws Exception {
		if(isEmpty()) throw new Exception("A fila está vazia.");
		return saida.pop();
	}

	@Override
	public Integer head() throws Exception {
		if(isEmpty()) throw new Exception("A fila está vazia.");
		return saida.top();
	}

	@Override
	public boolean isEmpty() {
		return saida.isEmpty();
	}

	@Override
	public boolean isFull() {
		return saida.isFull();
	}

}