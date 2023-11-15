package br.edu.uepb.eda.atividade04;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private int initial_size;
    private LinkedList<Integer>[] tabela;

    public TabelaHash(int initial_size) {
        this.tabela = new LinkedList[initial_size];
        this.initial_size = initial_size;
        for (int j = 0; j < initial_size; j++) {
            tabela[j] = new LinkedList<>();
        }
    }

    private int hashFunction(Integer element) {
        return element % initial_size;
    }

    @Override
    public void insert(Integer element) {
        int index = hashFunction(element);
        tabela[index].addFirst(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int index = hashFunction(element);
        if (tabela[index] == null) {
            throw new Exception("Elemento não encontrado na tabela");
        }
        if (!tabela[index].remove(element)) {
            throw new Exception("Elemento não encontrado na tabela");
        }
    }

    @Override
    public int search(Integer element) throws Exception {
        int index = hashFunction(element);
        if (tabela[index].contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento não encontrado na tabela");
        }
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < initial_size; i++) {
            result.append(i).append(": ");
            if (!tabela[i].isEmpty()) {
                for (Integer elem : tabela[i]) {
                    result.append(elem).append(", ");
                }
                result.setLength(result.length() - 2);
            }
            result.append("\n");
        }
        return result.toString();
    }
}

