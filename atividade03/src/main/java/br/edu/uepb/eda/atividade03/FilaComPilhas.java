package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
	private PilhaComLista stack1;
	private PilhaComLista stack2;

	public FilaComPilhas() {
		stack1 = new PilhaComLista();
		stack2 = new PilhaComLista();
	}

	public void enqueue(Integer element) throws Exception {
		stack1.push(element);
	}

	public int dequeue() throws Exception {
		if (isEmpty()) {
			throw new Exception("Fila vazia");
		}

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();
	}

	public int head() throws Exception {
		if (isEmpty()) {
			throw new Exception("Fila vazia");
		}

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.top();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	public boolean isFull() {
		return false;
	}
}
