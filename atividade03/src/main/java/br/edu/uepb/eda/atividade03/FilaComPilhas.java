package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    private PilhaComLista p1;
    private PilhaComLista p2;

    public FilaComPilhas() {
        p1 = new PilhaComLista();
        p2 = new PilhaComLista();
    }

    @Override
    public void enqueue(Integer element) throws Exception {
        p1.push(element);
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia!!!");
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
            throw new Exception("Fila vazia!!!");
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
        return false;
    }

}

