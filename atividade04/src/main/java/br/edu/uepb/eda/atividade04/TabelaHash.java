package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {

    private int m;
    private ListaEncadeada[] tabela;

    public TabelaHash(int m) {
        this.m = m;
        this.tabela = new ListaEncadeada[m];

        for (int i = 0; i < m; i++) {
            tabela[i] = new ListaEncadeada();
        }
    }

    private int hash(Integer key) {
        return key % m;
    }

    @Override
    public void insert(Integer element) {
        int hashValue = hash(element);
        tabela[hashValue].insert(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int hashValue = hash(element);
        tabela[hashValue].remove(element);
    }

    @Override
    public int search(Integer element) throws Exception {
        int i = 0;
        int hashValue;
        do {
            hashValue = hash(element);
            Integer result = tabela[hashValue].search(element);
            if (result != null) {
                return result.intValue();
            }
            i++;
        } while (tabela[hashValue].isNil() || i < m);

        throw new Exception("Element not found");
    }


    @Override
    public String print() {
        String result = "";
        for (int i = 0; i < m; i++) {
            result += i + ": ";
            if (!tabela[i].isEmpty()) {
                int[] elements = tabela[i].toArray();
                for (int j = 0; j < elements.length; j++) {
                    result += elements[j];
                    if (j < elements.length - 1) {
                        result += ", ";
                    }
                }
            }
            result += "\n";
        }
        return result;
    }
    
}
