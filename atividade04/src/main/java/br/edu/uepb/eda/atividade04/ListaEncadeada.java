package br.edu.uepb.eda.atividade04;

public class ListaEncadeada implements ListaEncadeada_IF {
    protected Integer data;
    protected ListaEncadeada next;

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public int size() {
        if (this.isEmpty())
            return 0;

        return 1 + this.next.size();
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (this.isEmpty())
            throw new Exception("Elemento não existe na lista encadeada");

        if (this.data.equals(element))
            return this.data;

        return this.next.search(element);
    }

    @Override
    public void insert(Integer element) {
        ListaEncadeada current = new ListaEncadeada();
        current.data = this.data;
        current.next = this.next;

        this.data = element;
        this.next = current;
    }

    @Override
    public void remove(Integer element) {
        if (this.isEmpty())
            return;

        if (this.data.equals(element)) {
            this.data = this.next.data;
            this.next = this.next.next;
        } else {
            this.next.remove(element);
        }
    }

    @Override
    public int[] toArray() {
        int[] array = new int[this.size()];

        toArray(array, this, 0);

        return array;
    }

    private static void toArray(int[] array, ListaEncadeada linkedList, int i) {
        if (!linkedList.isEmpty()) {
            array[i] = linkedList.data;
            toArray(array, linkedList.next, i + 1);
        }
    }
}
