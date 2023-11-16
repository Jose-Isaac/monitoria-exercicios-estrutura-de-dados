package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {
    private ListaEncadeada[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new ListaEncadeada[tamanho];

        for (int i = 0; i < this.tabela.length; i++) {
            this.tabela[i] = new ListaEncadeada();
        }
    }

    @Override
    public void insert(Integer element) {
        int mod = element % this.tamanho;

        this.tabela[mod].insert(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int mod = element % this.tamanho;

        this.tabela[mod].remove(element);

    }

    @Override
    public int search(Integer element) throws Exception {
        int mod = element % this.tamanho;

        return this.tabela[mod].search(element);

    }

    @Override
    public String print() {
        String printNaTela = "";

        for (int i = 0; i < this.tabela.length; i++) {
            int[] elements = this.tabela[i].toArray();

            printNaTela += i + ": ";

            for (int j = 0; j < elements.length; j++) {
                if (j + 1 == elements.length) {
                    printNaTela += elements[j];
                } else {
                    printNaTela += elements[j] + ", ";
                }
            }

            printNaTela += "\n";
        }

        return printNaTela;
    }
    
}
