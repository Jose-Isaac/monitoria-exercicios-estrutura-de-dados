package atividade04;



public class TabelaHash implements TabelaHash_IF {
    private int m;
    private ListaEncadeada[] tabela;

    public TabelaHash(int i) {
        m = i;
        tabela = new ListaEncadeada[m];
        for (int j = 0; j < m; j++) {
            tabela[j] = new ListaEncadeada();
        }
    }

    public void insert(Integer element) {
        int index = hash(element);
        tabela[index].insert(element);
    }

    public void remove(Integer element) throws Exception {
        int index = hash(element);
        int previousSize = tabela[index].size();
        tabela[index].remove(element);
        int currentSize = tabela[index].size();
        if (previousSize == currentSize) {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }

    public int search(Integer element) throws Exception {
        int index = hash(element);
        int result = tabela[index].search(element);
        if (result == -1) {
            throw new Exception("Elemento não encontrado na tabela.");
        }
        return result;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(i).append(": ");
            if (!tabela[i].isEmpty()) {
                int[] elements = tabela[i].toArray();
                for (int j = 0; j < elements.length; j++) {
                    sb.append(elements[j]);
                    if (j != elements.length - 1) {
                        sb.append(", ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int hash(int chave) {
        return chave % m;
    }
}
