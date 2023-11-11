package atividade04;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private static final int TAMANHO_INICIAL = 8; // Tamanho inicial da tabela
    private LinkedList<Integer>[] tabela; // Array de listas encadeadas

    public TabelaHash(Integer i) {
        this.tabela = new LinkedList[TAMANHO_INICIAL];
        for (int j = 0; j < TAMANHO_INICIAL; j++) {
            tabela[j] = new LinkedList<>();
        }
    }

    private int hashFunction(Integer element) {
        return element % TAMANHO_INICIAL; 
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
 
    public Integer search(Integer element) throws Exception {
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
        for (int i = 0; i < TAMANHO_INICIAL; i++) {
            result.append(i).append(": ");
            if (!tabela[i].isEmpty()) {
                for (Integer elem : tabela[i]) {
                    result.append(elem).append(", ");
                }
                result.setLength(result.length() - 2); // Remove a última vírgula e o espaço
            }
            result.append("\n");
        }
        return result.toString();
    }}