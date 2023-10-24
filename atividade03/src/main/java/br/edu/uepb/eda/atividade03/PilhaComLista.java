package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
    private ListaEncadeada lista;

    public PilhaComLista() {
        lista = new ListaEncadeada();
    }

    public void push(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("A pilha está cheia.");
        }
        lista.insert(element);
    }

    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        int topElement = lista.data;
        lista.data = lista.next.data;
        lista.next = lista.next.next;
        return topElement;
    }

    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        return lista.data;
    }

    public boolean isEmpty() {
        return lista.data == null;
    }

    public boolean isFull() {
        return isFullRecursive(lista, 0);
    }

    private boolean isFullRecursive(ListaEncadeada current, int count) {
        if (count >= 10) {
            return true;
        }
        if (current.data != null) {
            return isFullRecursive(current.next, count + 1);
        }
        return false;
    }
}

