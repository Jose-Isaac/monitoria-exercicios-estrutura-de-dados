package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    
    private PilhaComLista pilhaEntrada;
    private PilhaComLista pilhaSaida;

    public FilaComPilhas() {
        pilhaEntrada = new PilhaComLista();
        pilhaSaida = new PilhaComLista();
    }

    @Override
    public void enqueue(Integer element) throws Exception {
        if (pilhaEntrada.isFull()) {
            throw new Exception("fila cheia, compre um HD");
        }

        while (!pilhaSaida.isEmpty()) {
            pilhaEntrada.push(pilhaSaida.pop());
        }

        pilhaEntrada.push(element);

        while (!pilhaEntrada.isEmpty()) {
            pilhaSaida.push(pilhaEntrada.pop());
        }
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("fila vazia");
        }
        return pilhaSaida.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }
        return pilhaSaida.top();
    }

    @Override
    public boolean isEmpty() {
        return pilhaSaida.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilhaSaida.isFull();
    }
}

