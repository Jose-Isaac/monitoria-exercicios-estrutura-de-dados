package br.edu.uepb.eda;
public class TabelaHash implements TabelaHash_IF {
    private ListaEncadeada<Integer>[]tabela;
	private int tamanho=0;
	
	public TabelaHash(Integer tamanho) {
	    this.tabela = (ListaEncadeada<Integer>[]) new ListaEncadeada[tamanho];
	    for (int i = 0; i < tamanho; i++) {
	        tabela[i] = new ListaEncadeada<>();
	    }
	}
	
	public Integer hash(Integer element ) {
		return element%tabela.length;
	}



	@Override
	public void insert(Integer element) {
		int indice=hash(element);
		if(tabela[indice]==null) {
			tabela[indice]=new ListaEncadeada<>();
			
		}
		tabela[indice].adiciona(element);
		tamanho++;
		
	}

	@Override
	public void remove(Integer element) throws Exception {
		int indice=hash(element);
		if(tabela[indice]!=null) {
			if(tabela[indice].busca(element)) {
				tabela[indice].remove(element);
				tamanho--;
				System.out.println("---ELEMENTO EXCLUÍDO---"+element);
			}else {
				System.out.println("---ELEMENTO NÃO ENCONTRADO---");
			}
			}else {
				System.out.println("---LISTA VAZIA---");
			}
			
		}
		
	

	@Override
	public int search(Integer element) throws Exception {
		int indice=hash(element);
		if(tabela[indice]!=null) {
			if(tabela[indice].busca(element)) {
				System.out.println("---ELLEMENTO ENCONTRADO---");
				return element;
			}else {
				System.out.println("---ELEMENTO NÃO ENCONTRADO---");
			} 
		}else {
			System.out.println("---LISTA VAZIA---");
		}
		return indice;
			}

	@Override
	public String print() {
		StringBuilder listaImpressao=new StringBuilder();
		for(ListaEncadeada<Integer>lista:tabela) {
			if(lista!=null) {
				No_ListaEncadeada<Integer>atual=lista.getPrimeiro();
				while(atual!=null) {
					listaImpressao.append(atual.getElemento()).append("");
					atual.getProximo();
				}
			}
		}
		return listaImpressao.toString();
	}
    
}
