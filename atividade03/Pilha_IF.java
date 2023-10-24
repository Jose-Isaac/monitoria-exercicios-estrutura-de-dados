package atividade03;

/*
 * Interface para implementação da classe "PilhaComLista",
 * que deve ser implementada usando uma lista encadeada
 * com capacidade máxima de 10 elementos.
 */
public interface Pilha_IF {
	public void push(Integer element) throws Exception;
	public Integer pop() throws Exception;
	public Integer top() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
}