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
        if (isFull()) {
            throw new Exception("Fila está cheia.");
        } else {
            while(!p1.isEmpty()) {
                p2.push(p1.pop());
            }
            p1.push(element);
            while(!p2.isEmpty()) {
                p1.push(p2.pop());
            }
        }
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia.");
        } else {
            return p1.pop();

        }
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia.");
        } else {
            return p1.top();

        }
    }

    @Override
    public boolean isEmpty() {
        return p1.isEmpty();
    }

    @Override
    public boolean isFull() {
        if (p1.isFull()) {
            return true;
        } else {
            return false;
        }
    }

}