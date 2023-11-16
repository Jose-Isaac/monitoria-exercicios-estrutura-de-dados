package br.edu.uepb.eda.atividade04;

/*
 * Interface para implementação da classe "ListaEncadeada.java"
 * que deve ser implementada usando métodos recursivos.
 */
public interface ListaEncadeada_IF {
    public boolean isEmpty();
    public int size();
    public Integer search(Integer element) throws Exception; //lançar exceção caso não encontre
    public void insert(Integer element); //deve-se inserir no início da lista
    public void remove(Integer element);
    public int[] toArray();
}