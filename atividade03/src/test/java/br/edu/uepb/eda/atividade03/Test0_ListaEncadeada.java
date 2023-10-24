package br.edu.uepb.eda.atividade03;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class Test0_ListaEncadeada {
	
	static ListaEncadeada_IF list ;
		
	@Before //Instanciando a Lista antes de cada teste
	public void instanciaLista(){
		list = new ListaEncadeada();
	}
	

	@Test
	public void testIsEmpty(){
		//TestCase: Lista inicia vazia
		assertEquals(list.isEmpty(), true);
		
		//TestCase: isEmpty retorna false com lista não-vazia
		list.insert(2);
		assertEquals(list.isEmpty(), false);
	}


	@Test
	public void testSize(){
		//TestCase: Lista iniciza com size 0
		assertEquals(0, list.size());

		//Ao adicionar X (2) elementos, o size sera X
		list.insert(3);
		list.insert(5);
		assertEquals(list.size(), 2);
	}


	@Test
	public void testRemoveElement(){
		//TestCase: Remover elemento válido
		for(int i=1; i <= 5; i++){
			list.insert(i);
		}
		list.remove(3);
		assertEquals(4, list.size());
	}

	// Não retorna exceção de acordo com interface... mas era pra retornar :/
	/*@Test(expected = Exception.class)
	public void testRemoveElementException(){
		//TestCase: Remover elemento inexistente na lista
		list.remove(777);
	}*/

	
	@Test
	public void testSearch() throws Exception{
		//TestCase: Search encontra elemento
		//para verificar se realmente está procurando elemento (que não esteja na primeira posição)
		for(int i = 0; i < 5; i++){ list.insert(i); }
		assertEquals(3, list.search(3).intValue());
	}

	@Test (expected = Exception.class)
	public void testSearchException() throws Exception{
		//TestCase: Search não encontra elemento
		list.search(777);
	}

/* 
	@Test
	public void testInsert(){
		//TestCase: Elementos inseridos com sucesso
		list.insert(5);
		list.insert(4);
		//Fiquei em dúvida se podia usar list.data e list.next, já que ambos eram atributos não definidos na interface
		//Mas por via de dúvidas, se não puder usar, a função testToArray também valida se o insert está funcionando.
		assertEquals(4, list.data);
		assertEquals(5, list.next.data);
	}
*/

	@Test
	public void testToArray(){
		//TestCase: toArray de lista vazia
		int[] arrayVoid = list.toArray();
		int[] expectedVoid = new int[0];
		assertArrayEquals(expectedVoid, arrayVoid);

		//TestCase: toArray de lista com alguns elementos
		list.insert(5);
		list.insert(4);
		int[] array = list.toArray();
		int[] expected = {4, 5};
		assertArrayEquals(expected, array);
	}
}