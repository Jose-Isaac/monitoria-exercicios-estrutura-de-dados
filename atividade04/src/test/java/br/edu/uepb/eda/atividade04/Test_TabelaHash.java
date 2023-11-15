package br.edu.uepb.eda.atividade04;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_TabelaHash {

	private static TabelaHash_IF tabelaHash;
	
	@Before // Instanciando a Tabela hash antes de cada teste
	public void instanciaFila() {
		tabelaHash = new TabelaHash(7);
	}
	
	@Test // Testanto o insert e o Search
	public void testInsertESearch() throws Exception {
		int OK = 0;
		
		tabelaHash.insert(3);
		
		if(tabelaHash.search(3) == 3) {
			OK++;
		}
		
		tabelaHash.insert(2);
		
		if(tabelaHash.search(2) == 2) {
			OK++;
		}
		
		tabelaHash.insert(4);
		
		if(tabelaHash.search(4) == 4) {
			OK++;
		}
		
		assertTrue(OK == 3);
	}
	
	@Test // Testanto o remove
	public void testRemove() throws Exception {
		int OK = 0;
		
		tabelaHash.insert(3);
		tabelaHash.remove(3);
		
		try {
			tabelaHash.search(3);
		}catch(Exception e) {
			OK++;
		}
		
		tabelaHash.insert(5);
		tabelaHash.remove(5);
		
		try {
			tabelaHash.search(5);
		}catch(Exception e) {
			OK++;
		}
		
		tabelaHash.insert(9);
		tabelaHash.remove(9);
		
		try {
			tabelaHash.search(9);
		}catch(Exception e) {
			OK++;
		}
		
		assertTrue(OK == 3);
	}
	
	@Test // Testanto o print
	public void testPrint() throws Exception {
		
		tabelaHash.insert(4);
		tabelaHash.insert(5);
		tabelaHash.insert(7);
		
		assertEquals("\n0: 7, \n1: , \n2: , \n3: , \n4: 4, \n5: 5, \n6: , \n", tabelaHash.print());
		
	}

}
