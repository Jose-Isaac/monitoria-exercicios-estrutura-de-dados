package br.edu.uepb.eda.atividade04;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private int tamanho_inicial;
    private LinkedList<Integer>[] tabelahash;

    public TabelaHash(int initial_size) {
        this.tabelahash = new LinkedList[tamanho_inicial];
        this.tamanho_inicial = initial_size;
        for (int j = 0; j < initial_size; j++) {
            tabelahash[j] = new LinkedList<>();
        }
    }

    private int hashFunction(Integer element) {
        return element % tamanho_inicial;
    }

    @Override
    public void insert(Integer element) {
        int index = hashFunction(element);
        tabelahash[index].addFirst(element);
    }
    @Override
    public void remove(Integer element) throws Exception {
        int index = hashFunction(element);
        if (tabelahash[index] == null) {
            throw new Exception("Não encontrado na Tabela");
        }
        if (!tabelahash[index].remove(element)) {
            throw new Exception("Não encontrado na Tabela");
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        int index = hashFunction(element);
        if (tabelahash[index].contains(element)) {
            return element;
        } else {
            throw new Exception("Não encontrado na Tabela");
        }
    }
    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tamanho_inicial; i++) {
            result.append(i).append(": ");
            if (!tabelahash[i].isEmpty()) {
                for (Integer elem : tabelahash[i]) {
                    result.append(elem).append(", ");
                }
                result.setLength(result.length() - 2);
            }
            result.append("\n");
        }
        return result.toString();
    }
}