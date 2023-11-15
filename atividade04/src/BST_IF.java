
/*
 * Interface para implementa��o da classe "BST".
 */
public interface BST_IF {
	public void insert(int element);
	public Integer search(int element) throws Exception; //lan�ar exce��o caso n�o encontre
	public int[] preOrder();
	public int[] order();
	public int[] postOrder();
	public boolean isComplete();
}
