package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF{

    private ListaEncadeada[] table;
    private int size;

    public TabelaHash(int size) {
        this.size = size;
        this.table = new ListaEncadeada[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ListaEncadeada();
        }
    }

    @Override
    public void insert(Integer element) {
        try {
            table[element % size].search(element);
        } catch (Exception e) {
            table[element % size].insert(element);
        }
    }

    @Override
    public void remove(Integer element) throws Exception {
        try {
            table[element % size].search(element);
        } catch (Exception e) {
            throw new Exception("Elemento nao esta na tabela");
        }

        table[element % size].remove(element);
    }

    @Override
    public int search(Integer element) throws Exception {
        try {
            table[element % size].search(element);
            return element;
        } catch (Exception e) {
            throw new Exception("Elemento nao esta na tabela");
        }
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(i).append(": ");
            ListaEncadeada current = table[i];

            while (current != null) {
                if (current.data != null) {
                    sb.append(current.data);
                    if (current.next != null && current.next.data != null) {
                        sb.append(", ");
                    }
                }
                current = current.next;
            }

            sb.append("\n");
        }
        return sb.toString();
    }

    // Esses métodos são para o projeto, é o mesmo que insert e remove só que tem uma variável -num- de diferença
    public void insertForProject(int num, int element) {
        try {
            table[num % size].search(element);
        } catch (Exception e) {
            table[num % size].insert(element);
        }
    }

    public void removeForProject(int num, int element) throws Exception {
        try {
            table[num % size].search(element);
        } catch (Exception e) {
            throw new Exception("Elemento nao esta na tabela");
        }

        table[num % size].remove(element);
    }

    public int total(){
        int soma = 0;
        for (int i=0; i<size; i++){
            soma += table[i].size();
        }
        return soma;
    }
    
}
