package br.edu.uepb.eda.atividade03;

public interface Fila_IF {
	public void enqueue(Integer element) throws Exception;
	public Integer dequeue() throws Exception;
	public Integer head() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
}
