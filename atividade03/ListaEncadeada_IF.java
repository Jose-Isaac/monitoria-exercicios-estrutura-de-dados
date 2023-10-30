package atividade03;

/*
 * Interface para implementação da classe "ListaEncadeada"
 * que deve ser implementada usando métodos iterativos
 * considerando sempre uma lista de números inteiros não negativos.
 */
public interface ListaEncadeada_IF {
	public boolean isEmpty();
	public Integer size();
	public Integer search(int element) throws Exception; //lançar exceção caso não encontre
	public void insert(int element); //deve-se inserir no início da lista
	public void remove(int element);
	public Integer[] toArray();
}