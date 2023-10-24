package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {

	protected PilhaComLista p1;
	protected PilhaComLista p2;

	public FilaComPilhas() {
		p1 = new PilhaComLista();
		p2 = new PilhaComLista();
	}

	@Override
	public void enqueue(Integer element) throws Exception {
		if (p1.isFull()) {
			throw new Exception("Fila está cheia.");
		} else {
			while(!p1.isEmpty()) {
				p2.push(p1.pop());
			}
			p2.push(element);
			while(!p2.isEmpty()) {
				p1.push(p2.pop());
			}
		}
	}

	@Override
	public Integer dequeue() throws Exception {
		if (p1.isEmpty()) {
			throw new Exception("Fila vazia.");
		} else {
			int dequeued = p1.pop();
			return dequeued;
		}
	}

	@Override
	public Integer head() throws Exception {
		if (p1.isEmpty()) {
			throw new Exception("Fila vazia.");
		} else {
			int Head = p1.top();
			return Head;
		}
	}

	@Override
	public boolean isEmpty() {
		if (p1.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (p1.isFull()) {
			return false;
		} else {
			return false;
		}
	}

}
