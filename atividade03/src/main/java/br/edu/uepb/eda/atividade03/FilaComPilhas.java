package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {

	protected PilhaComLista ponta1 = new PilhaComLista();
	protected PilhaComLista ponta2 = new PilhaComLista();

	public void enqueue(Integer element) throws Exception {
		if(this.isFull()) {
			throw new Exception("LISTA CHEIA");
		}

		while(!ponta2.isEmpty()) {
			ponta1.push(ponta2.pop());
		}

		ponta2.push(element);

		while(!ponta1.isEmpty()) {
			ponta2.push(ponta1.pop());
		}
	}

	public Integer dequeue() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("LISTA VAZIA");
		}else {
			return ponta2.pop();
		}
	}

	public Integer head() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("LISTA VAZIA");
		}else {
			return ponta2.top();
		}
	}

	public boolean isEmpty() {
		return ponta2.isEmpty();
	}

	public boolean isFull() {
		return ponta2.isFull();
	}

}
