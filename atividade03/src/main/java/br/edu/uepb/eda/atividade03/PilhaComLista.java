package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
    private ListaEncadeada list;

    public PilhaComLista() {
        list = new ListaEncadeada();
    }

    public void push(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("Pilha CHEIA!");
        }
        list.insert(element);
    }

    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha VAZIA!");
        }
        int topElement = list.data;
        list.data = list.proximo.data;
        list.proximo = list.proximo.proximo;
        return topElement;
    }

    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha VAZIA!");
        }
        return list.data;
    }

    public boolean isEmpty() {
        return list.data == null;
    }

    public boolean isFull() {
        return isFullRecursive(list, 0);
    }

    private boolean isFullRecursive(ListaEncadeada current, int count) {
        if (count >= 10) {
            return true;
        }
        if (current.data != null) {
            return isFullRecursive(current.proximo, count + 1);
        }
        return false;
    }
}
