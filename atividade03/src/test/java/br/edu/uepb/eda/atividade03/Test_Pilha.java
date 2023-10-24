package br.edu.uepb.eda.atividade03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Pilha {
	private static Pilha_IF pilha;

	@BeforeEach //Instanciando a Pilha antes de cada teste
	public void instanciaPilha() {
		pilha = new PilhaComLista();
	}

	@Test
	public void testVazia() {
		assertTrue(pilha.isEmpty());
	}

	@Test
	public void testTop() {
		try {
			for (int i = 0; i < 5; i++) {
				pilha.push(i);
			}
			assertEquals(4, pilha.top());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testIsFull() {
		try {
			for (int i = 0; i < 10; i++) {
				pilha.push(i);
			}
			assertTrue(pilha.isFull());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testPop() {
		try {
			for (int i = 0; i < 5; i++) {
				pilha.push(i);
			}
			assertEquals(4, pilha.pop());
			assertEquals(3, pilha.top());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testPush() {
		try {
			pilha.push(0);
			assertTrue(pilha.pop() == 0);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Test
	public void testUnderflow() {
		assertThrows(Exception.class, () -> pilha.pop());
	}

	@Test
	public void testOverflow() {
		try {
			for (int i = 0; i < 10; i++) {
				pilha.push(i);
			}
			assertThrows(Exception.class, () -> pilha.push(1));
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
}