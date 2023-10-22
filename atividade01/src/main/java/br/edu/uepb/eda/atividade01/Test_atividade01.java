package atividade01;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * O teste considera um tamanho pequeno (2), 
 * um tamanho "grande" (10000) e
 * um tamanho impar (21)
 * [melhorar a criacao dos testes depois]
 */
public class Test_atividade01 {
	
	static Busca_IF b ;
	
	@Before
	public void setUp() throws Exception {
		b = new Busca();
	}

	
	@Test
	public void test_geraVetorNumericoOrdenado_len1() {
		assertTrue(b.geraVetorNumericoOrdenado(1).length == 1);
	}
	
	@Test
	public void test_geraVetorNumericoOrdenado_len1000() {
		assertTrue(b.geraVetorNumericoOrdenado(1000).length == 1000);
	}
	
	@Test
	public void test_geraVetorNumericoOrdenado_ordem() {
		int[] vetor = b.geraVetorNumericoOrdenado(5000);
		boolean ordenado = true;
		for (int i = 1; i < vetor.length; i++) {
			if (vetor[i] < vetor[i-1]) ordenado = false;
		}
		assertTrue(ordenado);
	}
	
	//buscaLinear_iterativa
	
	@Test
	public void test_vetorTamanho2_ok__buscaLinear_iterativa() {
		int n = 2;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		//printVetor(vetor); //auxiliar para entender erro
		assertTrue(b.buscaLinear_iterativa(vetor, k));
	}
	

	@Test
	public void test_vetorTamanho2_false__buscaLinear_iterativa() {
		int n = 2;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaLinear_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_ok__buscaLinear_iterativa() {
		int n = 21;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		//printVetor(vetor); //auxiliar para entender erro
		assertTrue(b.buscaLinear_iterativa(vetor, k));
	}
	

	@Test
	public void test_vetorTamanho21_false__buscaLinear_iterativa() {
		int n = 21;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaLinear_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho10000_ok__buscaLinear_iterativa() {
		int n = 10000;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaLinear_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho10000_false__buscaLinear_iterativa() {
		int n = 10000;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaLinear_iterativa(vetor, k));
	}
	
	//buscaLinear_recursiva
	
	@Test
	public void test_vetorTamanho2_ok__buscaLinear_recursiva() {
		int n = 2;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaLinear_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho2_false__buscaLinear_recursiva() {
		int n = 2;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaLinear_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_ok__buscaLinear_recursiva() {
		int n = 21;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaLinear_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_false__buscaLinear_recursiva() {
		int n = 21;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaLinear_recursiva(vetor, k));
	}
	
	
	@Test
	public void test_vetorTamanho1000_ok__buscaLinear_recursiva() {
		int n = 1000;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaLinear_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho10000_false__buscaLinear_recursiva() {
		int n = 10000;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaLinear_recursiva(vetor, k));
	}

	
	//buscaBinaria_iterativa
	
	@Test
	public void test_vetorTamanho2_ok__buscaBinaria_iterativa() {
		int n = 2;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaBinaria_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho2_false__buscaBinaria_iterativa() {
		int n = 2;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaBinaria_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_ok__buscaBinaria_iterativa() {
		int n = 21;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaBinaria_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_false__buscaBinaria_iterativa() {
		int n = 21;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaBinaria_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho10000_ok__buscaBinaria_iterativa() {
		int n = 10000;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaBinaria_iterativa(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho10000_false__buscaBinaria_iterativa() {
		int n = 10000;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaBinaria_iterativa(vetor, k));
	}

	
	//buscaBinaria_recursiva
	
	@Test
	public void test_vetorTamanho2_ok__buscaBinaria_recursiva() {
		int n = 2;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaBinaria_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho2_false__buscaBinaria_recursiva() {
		int n = 2;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaBinaria_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_ok__buscaBinaria_recursiva() {
		int n = 21;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaBinaria_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho21_false__buscaBinaria_recursiva() {
		int n = 21;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaBinaria_recursiva(vetor, k));
	}
	
	
	@Test
	public void test_vetorTamanho10000_ok__buscaBinaria_recursiva() {
		int n = 10000;
		int k = n-1; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertTrue(b.buscaBinaria_recursiva(vetor, k));
	}
	
	@Test
	public void test_vetorTamanho10000_false__buscaBinaria_recursiva() {
		int n = 10000;
		int k = Integer.MIN_VALUE; 
		int[] vetor = b.geraVetorNumericoOrdenado(n);
		assertFalse(b.buscaBinaria_recursiva(vetor, k));
	}

	//metodo auxiliar para facilitar entender possiveis erros
	private void printVetor(int[] vetor) {
		System.out.print("Vetor: [");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]);
			if(i != vetor.length-1) System.out.print(", ");
		}
		System.out.println("]");
		
	}
	

}



