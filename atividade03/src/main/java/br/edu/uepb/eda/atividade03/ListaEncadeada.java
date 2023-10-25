package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {

    protected ListaEncadeada prox;
    protected Integer element;

    private ListaEncadeada(Integer element, ListaEncadeada prox) {
        this.element = element;
        this.prox = prox;
    }

    public ListaEncadeada() {
        prox = null;
        element = null;
    }

    public boolean isEmpty() {
        return element == null;
    }

    public int size() {
        if (this.element == null) {
            return 0;
        } else if (this.prox == null) {
            return 1;
        }
        return this.prox.size() + 1;
    }

    public Integer search(Integer element) throws Exception {
        if (this.element.equals(element)) {
            return element;
        }
        if (this.prox == null) {
            throw new Exception("Elemento não encontrado");
        }
        return this.prox.search(element);
    }

    public void insert(Integer element) {
        ListaEncadeada noAtual = new ListaEncadeada(this.element, this.prox);
        this.element = element;
        this.prox = noAtual;
    }

    public void remove(Integer element) {
        if (this.element.equals(element)) {
            // main.ListaEncadeada noAux = this.prox;
            this.element = this.prox.element;
            this.prox = this.prox.prox;
        } else if (this.prox != null) {
            this.prox.remove(element);
        }

    }

    public int[] toArray() {
        int tamanho = size();
        int[] array = new int[tamanho];
        toArrayRecursive(this, array, 0, tamanho);
        return array;
    }

    public int[] toArrayRecursive(ListaEncadeada current_recursive, int[] arrayRecursive, int from, int to) {
        if (current_recursive != null && from < to) {
            arrayRecursive[from] = current_recursive.element;
            return toArrayRecursive(current_recursive.prox, arrayRecursive, from + 1, to);
        }
        return new int[]{};
    }
}
