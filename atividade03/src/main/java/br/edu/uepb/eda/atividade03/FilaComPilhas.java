package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    private PilhaComLista stack01 = new PilhaComLista();
    private PilhaComLista stack02 = new PilhaComLista();

    @Override
    public void enqueue(Integer element) throws Exception {
        if (this.stack01.isFull()) {
            throw new Exception("Fila cheia!");
        }

        while (!this.stack01.isEmpty()) {
            this.stack02.push(this.stack01.pop());
        }

        stack02.push(element);

        while (!this.stack02.isEmpty()) {
            this.stack01.push(this.stack02.pop());
        }
    }

    @Override
    public Integer dequeue() throws Exception {
        if (this.stack01.isEmpty())
            throw new Exception("Fila vazia!");

        return this.stack01.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (this.isEmpty())
            throw new Exception("Fila vazia!");

        return this.stack01.top();
    }

    @Override
    public boolean isEmpty() {
        return this.stack01.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.stack01.isFull();
    }

}
