package br.edu.uepb.eda.atividade01;
/*
 * Interface para implementa��o da classe "Busca".
 * Os m�todos booleanos devem retornar 'false' se 'k' n�o estiver no vetor 'numeros'. 
 */
public interface Busca_IF {
	
	int[] geraVetorNumericoOrdenado(int tamanho);
	
	boolean buscaLinear_iterativa(int[] numeros, int k);

	boolean buscaLinear_recursiva(int[] numeros, int k);

	boolean buscaBinaria_iterativa(int[] numeros, int k);

	boolean buscaBinaria_recursiva(int[] numeros, int k);

}
