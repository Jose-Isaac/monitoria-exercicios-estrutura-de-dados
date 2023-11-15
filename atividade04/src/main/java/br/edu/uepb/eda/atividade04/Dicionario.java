package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dicionario extends TabelaHash {

    private List<List<Palavra>> tabelaPalavras;

    public Dicionario(int tamanho) {
        super(tamanho);
        this.tabelaPalavras = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            this.tabelaPalavras.add(new LinkedList<>());
        }
    }

    public void insert(String palavra, String significado) {
        Palavra novaPalavra = new Palavra(palavra, significado);
        int indice = this.calcularIndice(novaPalavra);
        this.tabelaPalavras.get(indice).add(novaPalavra);
    }

    public void remove(String palavra) throws Exception {
        int indice = this.calcularIndice(new Palavra(palavra, null));
        List<Palavra> lista = this.tabelaPalavras.get(indice);

        if (lista.isEmpty()) {
            throw new Exception("Palavra não encontrada no dicionário");
        }

        for (Palavra p : lista) {
            if (p.getPalavra().equals(palavra)) {
                lista.remove(p);
                return;
            }
        }

        throw new Exception("Palavra não encontrada no dicionário");

    }

    public String search(String palavra) throws Exception {
        int indice = this.calcularIndice(new Palavra(palavra, null));
        List<Palavra> lista = this.tabelaPalavras.get(indice);

        if (lista.isEmpty()) {
            throw new Exception("Palavra não encontrada no dicionário");
        }

        for (Palavra p : lista) {
            if (p.getPalavra().equals(palavra)) {
                return p.getPalavra() + " - " + p.getSignificado();
            }
        }

        throw new Exception("Palavra não encontrada no dicionário");
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        for (int i = 0; i < tabelaPalavras.size(); i++) {
            result.append(letras[i]).append(": ");
            List<Palavra> lista = tabelaPalavras.get(i);
            for (int j = lista.size() - 1; j >= 0; j--) {
                result.append(lista.get(j)).append(", ");
            }
            if (!lista.isEmpty()) {
                result.delete(result.length() - 2, result.length());
            }
            result.append("\n");
        }
        return result.toString();
    }

    protected Integer calcularIndice(Palavra palavra) {
        char primeiraLetra = Character.toUpperCase(palavra.getPalavra().charAt(0));
        if (primeiraLetra >= 'A' && primeiraLetra <= 'Z') {
            return primeiraLetra - 'A';
        }
        return null;
    }

}
