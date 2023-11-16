package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {
	
	protected ListaEncadeada[] tabela;
	protected int tamanho;
	
	public TabelaHash(int tam) {
		this.tamanho = tam;
		this.tabela = new ListaEncadeada[tam];
		
		int i;
		for(i = 0; i < this.tamanho; i++) {
			this.tabela[i] = new ListaEncadeada();
		}
	}

	@Override
	public void insert(Integer element) {
		
		// Math.abs evita que um indice negativo seja procurado
		this.tabela[Math.abs(element % this.tamanho)].insert(element);
		
	}

	@Override
	public void remove(Integer element) throws Exception {
		
		this.search(element);
		
		this.tabela[element % this.tamanho].remove(element);
		
	}

	@Override
	public int search(Integer element) throws Exception {
		
		if(this.tabela[element % this.tamanho].search(element) == element) {
			return element;
		}else {
			throw new Exception("ELEMENTO NÃO ENCONTRADO");
		}
		
	}

	@Override
	public String print() {
		
		String result = "";
		
		int i;
		for(i = 0; i < this.tamanho; i++) {
			
			result += i + ":";
			
			int[] linha;
			if(this.tabela[i].valor == null) {
				linha = new int[]{-1};
				result += " ";
			}else {
				linha = this.tabela[i].toArray();
				int j;
				for(j = 0; j < linha.length; j++) {
					
					result += " " + linha[j];
					
					if(j+1 != linha.length) {
						result += ",";
					}

				}
			}
			
			result += "\n";
			
		}
		
		return result;
	}

}
