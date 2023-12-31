package br.edu.uepb.eda.atividade04;

/*
 * Interface para implementação da classe "BST".
 */
public interface BST_IF {
	public void insert(Integer element);
	public Integer search(Integer element) throws Exception; //lan�ar exce��o caso n�o encontre
	public Integer[] preOrder();
	public Integer[] order();
	public Integer[] postOrder();
	public boolean isComplete();
}
