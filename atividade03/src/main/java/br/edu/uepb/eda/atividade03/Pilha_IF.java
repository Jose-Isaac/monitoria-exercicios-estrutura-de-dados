package br.edu.uepb.eda.atividade03;

public interface Pilha_IF {
	public void push(Integer element) throws Exception;
	public Integer pop() throws Exception;
	public Integer top() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
}
