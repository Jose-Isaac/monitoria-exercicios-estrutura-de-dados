package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    private PilhaComLista pilha1;
    private PilhaComLista pilha2;

    public FilaComPilhas() {
        pilha1 = new PilhaComLista();
        pilha2 = new PilhaComLista();
    }

    public void enqueue(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("A fila está cheia.");
        }

        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop());
        }

        pilha1.push(element);

        while (!pilha2.isEmpty()) {
            pilha1.push(pilha2.pop());
        }
    }

    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        return pilha1.pop();
    }

    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        return pilha1.top();
    }

    public boolean isEmpty() {
        return pilha1.isEmpty();
    }

    public boolean isFull() {
        return pilha1.isFull();
    }
}
