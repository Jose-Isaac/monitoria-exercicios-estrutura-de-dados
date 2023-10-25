package br.edu.uepb.eda.atividade03;
public class ListaEncadeada implements ListaEncadeada_IF {

    private Node cabeca;

    private class Node {
        Integer dado;
        Node proximo;

        Node(Integer dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return cabeca == null;
    }

    @Override
    public int size() {
        int tamanho = 0;
        Node atual = cabeca;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        return tamanho;
    }

    @Override
    public Integer search(Integer elemento) throws Exception {
        Node atual = cabeca;
        while (atual != null) {
            if (atual.dado.equals(elemento)) {
                return elemento;
            }
            atual = atual.proximo;
        }
        throw new Exception("Elemento não encontrado na lista.");
    }

    @Override
    public void insert(Integer elemento) {
        Node novoNo = new Node(elemento);
        novoNo.proximo = cabeca;
        cabeca = novoNo;
    }

    @Override
    public void remove(Integer elemento) {
        if (cabeca == null) {
            return;
        }

        if (cabeca.dado.equals(elemento)) {
            cabeca = cabeca.proximo;
            return;
        }

        Node atual = cabeca;
        Node anterior = null;
        while (atual != null && !atual.dado.equals(elemento)) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual == null) {
            return;
        }

        anterior.proximo = atual.proximo;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size()];
        Node atual = cabeca;
        int indice = 0;
        while (atual != null) {
            array[indice++] = atual.dado;
            atual = atual.proximo;
        }
        return array;
    }
}



