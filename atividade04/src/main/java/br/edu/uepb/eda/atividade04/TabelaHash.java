package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {
	int tamanho;
	ListaEncadeada[] vetor;

	public TabelaHash(int tamanho) {
		this.tamanho = tamanho;
		vetor = new ListaEncadeada[tamanho];
		for (int i=0; i<tamanho; i++) {
			vetor[i] = new ListaEncadeada();
		}
	}


	@Override
	public void insert(Integer element) {
		int codigo = element%tamanho;
		vetor[codigo].insert(element);
	}

	@Override
	public void remove(Integer element) throws Exception {
		int indice = element % tamanho;

        if (vetor[indice].isEmpty()) throw new Exception("Elemento não encontrado na tabela");

        vetor[indice].remove(element);

	}

	@Override
	public int search(Integer element) throws Exception {
		int indice = element % tamanho;

        if (vetor[indice].isEmpty()) throw new Exception("Elemento não encontrado na tabela");

        return vetor[indice].search(element);
	}

	@Override
	public String print() {
		String result = new String();
		for (int i=0; i<tamanho; i++) {
			result += i + ": ";
			if (!vetor[i].isEmpty()) {
				int[] subvetor = vetor[i].toArray();
				for (int j=0; j<vetor[i].size(); j++) {
					if (j == vetor[i].size()-1) {
						result += subvetor[j];
					} else {
						result += subvetor[j] + ", ";
					}
				}
			}
			result += "\n";
		}
		return result;
	}

}
