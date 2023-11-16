package br.edu.uepb.eda.atividade04;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {

    private LinkedList<Integer>[] tabela;
    private int size;

    @SuppressWarnings("unchecked")
    public TabelaHash(int size) {
        this.tabela = new LinkedList[size];
        this.size = size;
        for(int index = 0; index < size; index++) {
            tabela[index] = new LinkedList<>();
        }
    }

    private Integer Hash(Integer element) {
        return element % size;
    }

    @Override
    public void insert(Integer element) {
        Integer index = Hash(element);
        tabela[index].addFirst(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        Integer index = Hash(element);
        if (tabela[index] == null) {
            throw new Exception("Elemento nao encontrado na tabela");
        }
        if (!tabela[index].remove(element)) {
            throw new Exception("Elemento nao encontrado na tabela");
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        Integer index = Hash(element);
        if (tabela[index].contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento nao encontrado na tabela");
        }
    }
    
    @Override
    public String print() {
        StringBuilder resultado = new StringBuilder();
        for (Integer index = 0; index < size; index++) {
            resultado.append(index).append(": ");
            if (!tabela[index].isEmpty()) {
                for (Integer elem : tabela[index]) {
                    resultado.append(elem).append(", ");
                }
                resultado.setLength(resultado.length() - 2);
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }
}

