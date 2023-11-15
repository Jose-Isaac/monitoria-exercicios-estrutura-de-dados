package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;
import java.util.List;

public class TabelaHash implements TabelaHash_IF {

    int size;
    List<Integer>[] table;

    public TabelaHash(int T) {
        size = T;
        table = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<>();
        }
    }

    @Override
    public void insert(Integer element) {
        int indice = element % size;
        table[indice].add(0, element);

    }

    @Override
    public void remove(Integer element) throws Exception {
        int i = element % size;
        if (table[i].remove(Integer.valueOf(element)) == false) {
            throw new Exception("Valor não encontrado!");
        }
    }

    @Override
    public int search(Integer element) throws Exception {
        int i = element % size;

        if (table[i].contains(element) == true) {
            return element;
        } else {
            throw new Exception("Valor não encontrado!");

        }
    }

    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(i).append(": ");
            List<Integer> lista = table[i];
            for (int j = 0; j < lista.size(); j++) {
                builder.append(lista.get(j));
                if (j < lista.size() - 1) {
                    builder.append(", ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    
}
