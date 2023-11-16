package br.edu.uepb.eda.atividade04;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0_BST {

	static BST_IF b;

	@Before // Instanciando a BST antes de cada teste
	public void instanciaBST() {
		b = new BST();
	}

	@Test
	public void testInsertAndSearch() throws Exception {
		b.insert(1);
		b.insert(50);
		b.insert(17);
		assertEquals(Integer.valueOf(50), b.search(50));
		assertEquals(Integer.valueOf(17), b.search(17));
		assertEquals(Integer.valueOf(1), b.search(1));
	}

	@Test
	public void testPreOrder() {
		b.insert(5);
		b.insert(3);
		b.insert(7);

		Integer[] expectedResult = { 5, 3, 7 };
		assertArrayEquals(expectedResult, b.preOrder());
	}

	@Test
	public void testOrder() {
		b.insert(5);
		b.insert(3);
		b.insert(7);

		Integer[] expectedResult = { 3, 5, 7 };
		assertArrayEquals(expectedResult, b.order());
	}

	@Test
	public void testPostOrder() {
		b.insert(5);
		b.insert(3);
		b.insert(7);

		Integer[] expectedResult = { 3, 7, 5 };
		assertArrayEquals(expectedResult, b.postOrder());
	}

	@Test
	public void testIsNotComplete() {
		b.insert(10);
		b.insert(5);
		b.insert(20);
		b.insert(15);
		b.insert(25);

		assertFalse(b.isComplete());
	}

	@Test
	public void testIsComplete() {
		b.insert(10);
		b.insert(5);
		b.insert(20);

		assertTrue(b.isComplete());
	}

	@Test(expected = Exception.class)
	public void testSearchException() throws Exception {
		b.insert(17);
		b.search(7);
	}

}