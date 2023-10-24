package br.edu.uepb.eda.atividade03;

/*
 * Interface para implementa��o da classe "ListaEncadeada"
 * que deve ser implementada usando m�todos recursivos.
 */
public interface ListaEncadeada_IF {
	public boolean isEmpty();
	public int size();
	public Integer search(Integer element) throws Exception; //lan�ar exce��o caso n�o encontre
	public void insert(Integer element); //deve-se inserir no in�cio da lista
	public void remove(Integer element);
	public Integer[] toArray();
}
