package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    private No head;

    public ListaEncadeada() {

    }

    public ListaEncadeada(No head) {
        head = null;
    }

    private class No {
        Integer data;
        No prox;

        No(Integer data) {
            this.data = data;
            this.prox = prox;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return sizeAuxiliar(head);
    }

    public int sizeAuxiliar(No noAtual) {
        if(noAtual == null) {
            return 0;
        }

        return 1 + sizeAuxiliar(noAtual.prox);
    }

    public Integer search(Integer element) throws Exception {
        return searchAuxiliar(head, element, 0);
    }

    public Integer searchAuxiliar(No noAtual, Integer element, int index) throws Exception {
        if(noAtual == null) {
            throw new Exception("Elemento não encontrado!!!");
        }

        if(noAtual.data.equals(element)) {
            return element;
        }

        return searchAuxiliar(noAtual.prox, element, index + 1);
    }

    public void insert(Integer element) {
        No novoNo = new No(element);
        novoNo.prox = head;
        head = novoNo;
    }

    public void remove(Integer element) {
        head = removeAuxiliar(head, element);
    }

    public No removeAuxiliar(No noAtual, Integer element) {
        if(noAtual == null) {
            return null;
        }

        if(noAtual.data.equals(element)) {
            return noAtual.prox;
        }
        
        noAtual.prox = removeAuxiliar(noAtual.prox, element);
        return noAtual;
    }

    public int[] toArray() {
        int[] array = new int[size()];
        toArrayAuxiliar(head, array, 0);

        return array;
    }
    
    private void toArrayAuxiliar(No noAtual, int[] array, int index) {
        if(noAtual == null) {
            return;
        }

        array[index] = noAtual.data;
        toArrayAuxiliar(noAtual.prox, array, index + 1);
    }
}
