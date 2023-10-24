package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    private PilhaComLista p1;
    private PilhaComLista p2;

    public FilaComPilhas() {
        p1 = new PilhaComLista();
        p2 = new PilhaComLista();
    }

    public void enqueue(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("Fila CHEIA!");
        }

        while (!p1.isEmpty()) {
            p2.push(p1.pop());
        }
        p1.push(element);

        while (!p2.isEmpty()) {
            p1.push(p2.pop());
        }
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila VAZIA!");
        }
        return p1.pop();
    }

    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila VAZIA!");
        }
        return p1.top();
    }

    public boolean isEmpty() {
        return p1.isEmpty();
    }

    public boolean isFull() {
        return p1.isFull();
    }
}
