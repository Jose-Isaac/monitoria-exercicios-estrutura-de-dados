package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;


public class Test0_Fila {
	
	static Fila_IF fila ;
		
	@Before //Instanciando a Fila antes de cada teste
	public void instanciaFila() throws Exception{
		fila = new FilaComPilhas();
	}
	
	@Test
	public void testEnqueue() throws Exception{
		//TestCase: Elementos enfileirados com sucesso
		fila.enqueue(5);
		fila.enqueue(4);
		assertEquals(5, fila.head().intValue());
	}

	@Test (expected = Exception.class)
	public void testEnqueueException() throws Exception {
		//TestCase: queueOverflow
		for(int i = 0; i<11; i++){
			fila.enqueue(i);
		}
	}


	@Test
	public void testDequeue() throws Exception{
		//TestCase: Dequeue funcionando corretamente
		for(int i = 0; i < 3; i++){ fila.enqueue(i); }
		fila.dequeue();
		assertEquals(1, fila.head().intValue());
	}

	@Test (expected = Exception.class)
	public void testDequeueException() throws Exception{
		//TestCase: queueUnderflow
		fila.dequeue();
	}


	@Test
	public void testHead() throws Exception{
		//TestCase: head() retornando primeiro elemento adicionado
		fila.enqueue(2);
		fila.enqueue(7);
		assertEquals(2, fila.head().intValue());

		//TestCase: head() retornando SEMPRE o primeiro elemento 
		fila.dequeue();
		assertEquals(7, fila.head().intValue());
	}

	@Test (expected = Exception.class)
	public void testHeadException() throws Exception{
		//TestCase: Tenta retornar head inexistente
		fila.head();
	}


	@Test
	public void testIsEmpty() throws Exception{
		//TestCase: fila vazia
		assertEquals(true, fila.isEmpty());

		//TestCase: Fila não-vazia
		fila.enqueue(3);
		assertEquals(false, fila.isEmpty());
	}

	@Test
	public void testIsFull() throws Exception{
		//TestCase: fila não-cheia
		assertEquals(false, fila.isFull());

		//TestCase: fila cheia
		for(int i = 0; i<10; i++){ fila.enqueue(i); }
		assertEquals(true, fila.isFull());
	}
}
