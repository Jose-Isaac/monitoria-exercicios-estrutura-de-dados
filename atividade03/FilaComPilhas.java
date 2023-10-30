package atividade03;

public class FilaComPilhas implements Fila_IF {

	final int CAPACIDADE = 10;
	PilhaComLista p1 = new PilhaComLista();
	PilhaComLista p2 = new PilhaComLista();
	int tamanho = 0;

	public void enqueue(int element) throws Exception {
		p1.push(element);
		tamanho++;
	}

	public Integer dequeue() throws Exception {
		if (p1.isEmpty() && p2.isEmpty()) {
			throw new Exception("Fila vazia!");
		} else {
			while (!p1.isEmpty()) {
				p2.push(p1.pop());
			}
			Integer resultado = p2.pop();
			while (!p2.isEmpty()) {
				p1.push(p2.pop());
			}
			tamanho--;
			return resultado;
		}

	}

	public Integer head() throws Exception {
		if (p1.isEmpty()) {
			throw new Exception("Fila vazia. ");
		} else {
			while (!p1.isEmpty()) {
				p2.push(p1.pop());
			}
			Integer headLista = p2.top();

			while (!p2.isEmpty()) {
				p1.push(p2.pop());
			}
			return headLista;
		}
	}

	public boolean isEmpty() {
		return p1.isEmpty() && p2.isEmpty();
	}

	public boolean isFull() {
		return tamanho == CAPACIDADE;
	}

}