package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Test0_Pilha {
	private static Pilha_IF p;

	@Before // Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception {
		p = new PilhaComLista();
	}

	@Test
	public void testVazia() throws Exception {
		assertTrue(p.isEmpty());
	}

	@Test
	public void testPush() throws Exception {
		p.push(5);
		assertTrue(p.top() == 5);
	}

	@Test
	public void testPop() throws Exception {
		for(int i = 1; i <= 5; i++) {
			p.push(i);
		}

		for(int i = 1; i <= 5; i++) {
			p.pop();
		}

		assertTrue(p.isEmpty());
	}
}
