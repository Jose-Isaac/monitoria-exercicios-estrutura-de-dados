package ExemploAplicacao;
import Atividade04.TabelaHash;

import java.util.LinkedList;

public class TabelaHashManga extends TabelaHash {
    protected LinkedList<Manga>[] tabela;
    public TabelaHashManga(int tamanho) {
        super(tamanho);
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    @Override
    protected int calcularIndice(int idManga) {
        return idManga % tamanho;
    }

    public void insert(Manga manga) {
        int indice = calcularIndice(manga.getId());
        tabela[indice].addFirst(manga);
    }

    public void remove(Manga manga) throws Exception {
        int indice = calcularIndice(manga.getId());
        if (tabela[indice].remove(manga)) {
            return;
        }
        throw new Exception("Manga não encontrado na tabela.");
    }

    public Manga search(int idManga) throws Exception {
        int indice = calcularIndice(idManga);
        for (Manga manga : tabela[indice]) {
            if (manga.getId() == idManga) {
                return manga;
            }
        }
        throw new Exception("Manga não encontrado na tabela.");
    }
}
