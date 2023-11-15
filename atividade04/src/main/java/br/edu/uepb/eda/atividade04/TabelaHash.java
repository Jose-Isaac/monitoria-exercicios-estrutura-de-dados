package br.edu.uepb.eda.atividade04;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {

	private LinkedList<Integer>[] tabela;
	private int tamanho;

	public TabelaHash(int tamanho) {
		this.tabela = new LinkedList[tamanho];
		this.tamanho = tamanho;
		for (int indice = 0; indice < tamanho; indice++) {
			tabela[indice] = new LinkedList<>();
		}
	}

	private int Hash(Integer element) {
		return element % tamanho;
	}

	@Override
	public void insert(Integer element) {
		int índice = Hash(element);
		tabela[índice].addFirst(element);
	}

	@Override
	public void remove(Integer element) throws Exception {
		int indice = Hash(element);
		if (tabela[indice] == null) {
			throw new Exception("Elemento não encontrado");
		}
		if (!tabela[indice].remove(element)) {
			throw new Exception("Elemento não encontrado");
		}
	}

	@Override
	public int search(Integer element) throws Exception {
		int indice = Hash(element);
		if (tabela[indice].contains(element)) {
			return element;
		} else {
			throw new Exception("Elemento não encontrado");
		}
	}

	@Override
	public String print() {
		StringBuilder resultado = new StringBuilder();
		for (int indice = 0; indice < tamanho; indice++) {
			resultado.append(indice).append(": ");
			if (!tabela[indice].isEmpty()) {
				for (Integer elem : tabela[indice]) {
					resultado.append(elem).append(", ");
				}
				resultado.setLength(resultado.length() - 2);
			}
			resultado.append("\n");
		}
		return resultado.toString();
	}
}
