package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {

    private PilhaComLista p1;
    private PilhaComLista p2;

    public FilaComPilhas() {
        this.p1 = new PilhaComLista();
        this.p2 = new PilhaComLista();
    }

    @Override
    public void enqueue(Integer elemento) throws Exception {
        if (isFull()) {
            throw new Exception("A fila esta cheia.");
        }
        p1.push(elemento);
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Nao da para remover pois esta vazia.");
        }
        if (p2.isEmpty()) {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
        }
        return p2.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila esta vazia.");
        }
        if (p2.isEmpty()) {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
        }
        return p2.top();
    }

    @Override
    public boolean isEmpty() {
        return p1.isEmpty() && p2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return p1.isFull();
    }
}
