package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {

private ListaEncadeada array;

    public PilhaComLista() {
        array = new ListaEncadeada();
    }

    public void push(Integer elemento) throws Exception {
        if (isFull()) {
            throw new Exception("A pilha está cheia");
        }
        
        array.insert(elemento);
    }

    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia");
        }
        
        int topelemento = array.dado;
        array.dado = array.next.dado;
        array.next = array.next.next;
        return topelemento;
    }

    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha VAZIA!");
        }
        else {
            return array.dado;
        }
        
    }

    public boolean isEmpty() {
        return array.dado == null;
    }

    public boolean isFull() {
        return isFullRecursivo(array, 0);
    }

    private boolean isFullRecursivo(ListaEncadeada atual, int contagem) {
        if (contagem >= 10) {
            return true;
        }

        else if (atual.dado != null) {
            return isFullRecursivo(atual.next, contagem + 1);
        }

        else {
            return false;
        }
    }
}