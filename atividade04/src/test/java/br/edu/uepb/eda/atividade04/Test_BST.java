package atividade04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class Test_BST {

	private static BST_IF BST;
	
	@Before // Instanciando a BST antes de cada teste
	public void instanciaFila() {
		BST = new BST();
	}
	
	@Test // Testanto o insert e o Search
	public void testInsertESearch() throws Exception {
		int OK = 0;
		
		BST.insert(3);
		
		if(BST.search(3) == 3) {
			OK++;
		}
		
		BST.insert(2);
		
		if(BST.search(2) == 2) {
			OK++;
		}
		
		BST.insert(4);
		
		if(BST.search(4) == 4) {
			OK++;
		}
		
		assertTrue(OK == 3);
	}
	
	@Test // Testanto o preOrder
	public void testPreOrder() {

		BST.insert(3);
		BST.insert(2);
		BST.insert(4);
		
		assertArrayEquals(new int[]{3,2,4}, BST.preOrder());
		
	}
	
	@Test // Testanto o order
	public void testOrder() {

		BST.insert(3);
		BST.insert(2);
		BST.insert(4);
		
		assertArrayEquals(new int[]{2,3,4}, BST.order());
		
	}
	
	@Test // Testanto o postOrder
	public void testPostOrder() {

		BST.insert(3);
		BST.insert(2);
		BST.insert(4);
		
		assertArrayEquals(new int[]{2,4,3}, BST.postOrder());
		
	}
	
	@Test // Testanto o isComplete
	public void isComplete() {
		int OK = 0;
		
		BST.insert(8);
		BST.insert(3);
		BST.insert(10);
		
		if(BST.isComplete()) {
			OK++;
		}
		
		BST.insert(5);
		BST.insert(1);
		
		if(!BST.isComplete()) {
			OK++;
		}
		
		BST.insert(11);
		
		if(!BST.isComplete()) {
			OK++;
		}
		
		BST.insert(9);
		
		if(BST.isComplete()) {
			OK++;
		}
		
		assertTrue(OK == 4);
	}

}
