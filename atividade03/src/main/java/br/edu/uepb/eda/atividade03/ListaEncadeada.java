package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF{
    protected Integer data;
    protected ListaEncadeada next;

    public ListaEncadeada() {
        this.data = null;
        this.next = null;
    }

    @Override
    public boolean isEmpty() {
        return this.data == null;
    }

    @Override
    public int size() {
        if (this.data == null){
            return 0;
        }
        return 1 + this.next.size();
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (this.data == null) {
            throw new Exception("Elemento inexistente");
        }
    
        if (this.data.equals(element)) {
            return element;
        }
    
        return this.next.search(element);
    }

    @Override
    public void insert(Integer element) {
        if (isEmpty()) {
            this.data = element;
            this.next = new ListaEncadeada();
        } else {
            ListaEncadeada newNode = new ListaEncadeada();
            newNode.data = this.data;
            newNode.next = this.next;
    
            this.data = element;
            this.next = newNode;
        }
    }

    @Override
    public void remove(Integer element) {
        if (this.data == null) {
            return;
        }
    
        if (this.data.equals(element)) {
            this.data = this.next.data;
            this.next = this.next.next;
        } else {
            this.next.remove(element);
        }
    }

    @Override
    public int[] toArray() {
        int count = 0;
        ListaEncadeada lista = this;

        while (lista != null) {
            count++;
            lista = lista.next;
        }

        int[] array = new int[count];
        lista = this;

        for (int i = 0; lista != null; i++) {
            if (lista.data != null){
                array[i] = lista.data;
            }
            lista = lista.next;
        }

        return array;
    }
}
