package atividade04;
import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private LinkedList<Integer>[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int calcularIndice(int elemento) {
        return elemento % tamanho;
    }

    @Override
    public void insert(int elemento) {
        int indice = calcularIndice(elemento);
        tabela[indice].addFirst(elemento); // Adiciona o elemento no início da lista para manter a ordem
    }

    @Override
    public void remove(int elemento) throws Exception {
        int indice = calcularIndice(elemento);
        if (tabela[indice].remove(Integer.valueOf(elemento))) {
            return;
        }
        throw new Exception("Elemento não encontrado na tabela.");
    }

    @Override
    public int search(int elemento) throws Exception {
        int indice = calcularIndice(elemento);
        for (int num : tabela[indice]) {
            if (num == elemento) {
                return num;
            }
        }
        throw new Exception("Elemento não encontrado na tabela.");
    }

    @Override
    public String print() {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            resultado.append(i).append(": ");
            if (!tabela[i].isEmpty()) {
                for (int num : tabela[i]) {
                    resultado.append(num).append(", ");
                }
                resultado.setLength(resultado.length() - 2);
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }


}