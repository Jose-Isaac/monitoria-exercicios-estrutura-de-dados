package br.edu.uepb.eda.atividade03;
import java.util.EmptyStackException;
import java.util.Stack;

public class FilaComPilhas implements Fila_IF {

    private Stack<Integer> pilha1;
    private Stack<Integer> pilha2;

    public FilaComPilhas() {
        pilha1 = new Stack<>();
        pilha2 = new Stack<>();
    }

    @Override
    public void enqueue(Integer element) throws Exception {
        pilha1.push(element);
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (pilha2.isEmpty()) {
            while (!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop());
            }
        }

        return pilha2.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (pilha2.isEmpty()) {
            while (!pilha1.isEmpty()) {
                pilha2.push(pilha1.pop());
            }
        }

        return pilha2.peek();
    }

    @Override
    public boolean isEmpty() {
        return pilha1.isEmpty() && pilha2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
