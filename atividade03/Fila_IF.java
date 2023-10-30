package atividade03;

/*
 * Interface para implementação da classe "FilaComPilhas", a qual deve
 * ser implementada usando duas instâncias da classe "PilhaComLista".
 */
public interface Fila_IF {
	public void enqueue(int element) throws Exception;
	public Integer dequeue() throws Exception;
	public Integer head() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
}
