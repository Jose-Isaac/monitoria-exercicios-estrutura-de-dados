package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test0_Pilha {

	private static Pilha_IF pilha;
	
	@Before //Instanciando a Pilha antes de cada teste
	public void instanciaPilha() throws Exception{
		pilha = new PilhaComLista();
	}
	
	@Test
	public void testPush() throws Exception{
		//TestCase: push de elemento na pilha funcional
		pilha.push(5);
		assertEquals(5, pilha.top().intValue());

		//TestCase: Checa se realmente elemento adicionado está no topo
		pilha.push(3);
		assertEquals(3, pilha.top().intValue());
	}

	@Test (expected = Exception.class)
	public void testPushException() throws Exception{
		//TestCase: stackOverFlow
		for(int i = 0; i<11; i++){
			pilha.push(i);
		}
	}


	@Test
	public void testPop() throws Exception{
		//TestCase: Pop removendo elemento do topo corretamente
		pilha.push(3);
		pilha.pop();
		assertEquals(true, pilha.isEmpty());

		//TestCase: Checa se relemento removido é realmente o do topo
		pilha.push(5);
		pilha.push(3);
		pilha.pop();
		assertEquals(5, pilha.top().intValue());
	}

	@Test (expected = Exception.class)
	public void testPopException() throws Exception{
		//TestCase: stackUnderFlow
		pilha.pop();
	}


	@Test
	public void testTop() throws Exception{
		//TestCase: Top funcional
		pilha.push(7);
		pilha.push(8);
		assertEquals(8, pilha.top().intValue());
	}

	@Test (expected = Exception.class)
	public void testTopException() throws Exception{
		//TestCase: Tentar pegar top de pilha sem top
		pilha.top();
	}


	@Test
	public void testIsEmpty() throws Exception{
		//TestCase: isEmpty retornando true pra pilha vazia
		assertEquals(true, pilha.isEmpty());

		//TestCase: isEmpty retornando false para pilha com elemento
		pilha.push(3);
		assertEquals(false, pilha.isEmpty());
	}


	@Test
	public void testIsFull() throws Exception{
		//TestCase: isFull retornando false para pilha vazia
		assertEquals(false, pilha.isFull());

		//TestCase: isFull retornando true para pilha cheia
		for(int i = 0; i<10; i++){
			pilha.push(i);
		}
		assertEquals(true, pilha.isFull());
	}
}