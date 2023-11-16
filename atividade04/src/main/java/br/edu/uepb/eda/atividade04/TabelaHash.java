package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {

    protected ListaEncadeada[] table;
    protected int size;

    public TabelaHash (int size) {
        this.size = size;
        this.table = new ListaEncadeada[size];
    }

    @Override
    public void insert(Integer element) {
        int h = hash(element);
        if (this.table[h] == null) {
            this.table[h] = new ListaEncadeada(element, null);
        } else {
            this.table[h].insert(element);
        }
    }

    public int hash (int key) {
        return (key % this.table.length);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int h = hash(element);
        if (this.table[h] != null) {
            this.table[h].remove(element);
        } else {
            throw new Exception ("Não encontrado");
        }
    }

    @Override
    public int search(Integer element) throws Exception {
        int h = hash(element);
        if (this.table[h].search(element) == null) {
            throw new Exception ("Não encontrado");
        } return this.table[h].search(element);
    }

    @Override
    public String print() {
        String elementos = "";
        ListaEncadeada aux;
        for (int i = 0; i < this.size; i++) {
            elementos += i + ":   ";
            aux = table[i];
            while (aux != null) {
                if (aux.data != null) {
                    elementos += aux.data + ", ";
                }
                aux = aux.proximo;
            }
            elementos = elementos.substring(0, elementos.length()-2) + "\n";
            elementos = elementos.replaceAll(":   ", ": ");
        }
        return elementos;
    }
}
package main.java.br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {

    protected ListaEncadeada[] table;
    protected int size;

    public TabelaHash (int size) {
        this.size = size;
        this.table = new ListaEncadeada[size];
    }

    @Override
    public void insert(Integer element) {
        int h = hash(element);
        if (this.table[h] == null) {
            this.table[h] = new ListaEncadeada(element, null);
        } else {
            this.table[h].insert(element);
        }
    }

    public int hash (int key) {
        return (key % this.table.length);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int h = hash(element);
        if (this.table[h] != null) {
            this.table[h].remove(element);
        } else {
            throw new Exception ("Não encontrado");
        }
    }

    @Override
    public int search(Integer element) throws Exception {
        int h = hash(element);
        if (this.table[h].search(element) == null) {
            throw new Exception ("Não encontrado");
        } return this.table[h].search(element);
    }

    @Override
    public String print() {
        String elementos = "";
        ListaEncadeada aux;
        for (int i = 0; i < this.size; i++) {
            elementos += i + ":   ";
            aux = table[i];
            while (aux != null) {
                if (aux.data != null) {
                    elementos += aux.data + ", ";
                }
                aux = aux.proximo;
            }
            elementos = elementos.substring(0, elementos.length()-2) + "\n";
            elementos = elementos.replaceAll(":   ", ": ");
        }
        return elementos;
    }
}
