package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    protected ListaEncadeada proximo;
    protected Integer data;

    public ListaEncadeada() {
        data = null;
        proximo = null;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public int size() {
        return sizeRecursive(this);
    }

    private int sizeRecursive(ListaEncadeada current) {
        if (current.data == null) {
            return 0;
        }
        return 1 + sizeRecursive(current.proximo);
    }

    public Integer search(Integer element) throws Exception {
        return searchRecursive(this, element);
    }

    private Integer searchRecursive(ListaEncadeada current, Integer element) throws Exception {
        if (current.data == null) {
            throw new Exception("Elemento NÃO ENCONTRADO!");
        }
        if (current.data.equals(element)) {
            return element;
        }
        return searchRecursive(current.proximo, element);
    }

    public void insert(Integer element) {
        ListaEncadeada newNode = new ListaEncadeada();
        newNode.data = this.data;
        newNode.proximo = this.proximo;

        this.data = element;
        this.proximo = newNode;
    }

    public void remove(Integer element) {
        removeRecursive(this, element);
    }

    private void removeRecursive(ListaEncadeada current, Integer element) {
        if (current.data != null) {
            if (current.data.equals(element)) {
                current.data = current.proximo.data;
                current.proximo = current.proximo.proximo;
            } else {
                removeRecursive(current.proximo, element);
            }
        }
    }

    public int[] toArray() {
        int[] array = new int[size()];
        toArrayRecursive(this, array, 0);
        return array;
    }

    private void toArrayRecursive(ListaEncadeada current, int[] array, int index) {
        if (current.data != null) {
            array[index] = current.data;
            if (current.proximo != null) {
                toArrayRecursive(current.proximo, array, index + 1);
            }
        }
    }
}
