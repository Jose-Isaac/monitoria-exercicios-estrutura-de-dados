package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {

    private ListaEncadeada[] table;
    private int length;

    public TabelaHash(int length) {
        this.length = length;
        this.table = new ListaEncadeada[length];

        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new ListaEncadeada();
        }

    }

    @Override
    public void insert(Integer element) {
        int i = element % this.length;

        this.table[i].insert(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int i = element % this.length;

        this.table[i].remove(element);
    }

    @Override
    public int search(Integer element) throws Exception {
        int i = element % this.length;

        return this.table[i].search(element);
    }

    @Override
    public String print() {
        String stringToPrint = "";

        for (int i = 0; i < this.table.length; i++) {
            int[] elements = this.table[i].toArray();

            stringToPrint += i + ": ";

            for (int j = 0; j < elements.length; j++) {
                if (j + 1 == elements.length) {
                    stringToPrint += elements[j];
                } else {
                    stringToPrint += elements[j] + ", ";
                }
            }

            stringToPrint += "\n";
        }

        return stringToPrint;
    }

}
