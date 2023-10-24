package br.edu.uepb.eda.atividade01;
/*
 * Interface para implementação da classe "Busca".
 * Os métodos booleanos devem retornar 'false' se 'k' não estiver no vetor 'numeros'.
 * O método buscaLinear_iterativa2 deve considerar 
 */
public interface Busca_IF {
	
	int[] geraVetorNumericoOrdenado(int tamanho);
	
	boolean buscaLinear_iterativa(int[] numeros, int k);

	boolean buscaLinear_recursiva(int[] numeros, int k);
	
	boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k);

	boolean buscaBinaria_iterativa(int[] numeros, int k);

	boolean buscaBinaria_recursiva(int[] numeros, int k);

}