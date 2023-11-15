package br.edu.uepb.eda.atividade04;

public interface ListaEncadeada_IF {
		public boolean isEmpty();
		public int size();
		public int search(Integer element) throws Exception; //lançar exceção caso não encontre
		public void insert(Integer element); //deve-se inserir no início da lista
		public void remove(Integer element);
		public Integer[] toArray();
	
}
