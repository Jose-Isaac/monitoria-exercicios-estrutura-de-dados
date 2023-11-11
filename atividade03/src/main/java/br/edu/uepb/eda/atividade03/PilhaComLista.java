package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {

    final int TAMANHO = 10;
    ListaEncadeada l = new ListaEncadeada();

    int size = 0;

    public void push(int element) throws Exception {
        if (l.size() == TAMANHO) {
            throw new Exception("Pilha cheia. ");
        }
        l.insert(element);
    }

    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha vazia. ");
        }
        int valor = top();
        l.remove(valor);
        return valor;
    }

    public Integer top() throws Exception {
        if (l.isEmpty()) {
            throw new Exception("A pilha está vazia!");
        }
        return l.getHead().getData();
    }

    public boolean isEmpty() {
        return l.isEmpty();
    }

    public boolean isFull() {
        return l.size() == TAMANHO;
    }

}
