package br.edu.uepb.eda.atividade03;

/*
 * Interface para implementa��o da classe "ListaEncadeada"
 * que deve ser implementada usando m�todos recursivos.
 */
public interface ListaEncadeada_IF {
	public boolean isEmpty();
	public Integer size();
	public Integer search(int element) throws Exception; //lançar exceção caso não encontre
	public void insert(int element); //deve-se inserir no início da lista
	public void remove(int element);
	public Integer[] toArray();
}
