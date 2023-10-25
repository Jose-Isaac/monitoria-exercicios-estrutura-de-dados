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
        if (isFull()) {
            throw new Exception("fila cheia, compre um HD");
        }
        pilhaEntrada.push(element);
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("fila vazia");
        }

        if (pilhaSaida.isEmpty()) {
            while (!pilhaEntrada.isEmpty()) {
                pilhaSaida.push(pilhaEntrada.pop());
            }
        }

        return pilhaSaida.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        if (pilhaSaida.isEmpty()) {
            while (!pilhaEntrada.isEmpty()) {
                pilhaSaida.push(pilhaEntrada.pop());
            }
        }

        return pilhaSaida.top();
    }

    @Override
    public boolean isEmpty() {
        return pilhaEntrada.isEmpty() && pilhaSaida.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilhaEntrada.isFull();
    }
}

