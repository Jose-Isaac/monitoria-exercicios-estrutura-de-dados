package atividade01;

public class Busca implements Busca_IF {

	@Override
	public int[] geraVetorNumericoOrdenado(int tamanho) {
		int novo_vetor[] = new int[tamanho], i;
		for (i = 1; i <= tamanho; i++) {
			novo_vetor[i-1] = i;
		}
		return novo_vetor;
	}

	@Override
	public boolean buscaLinear_iterativa(int[] numeros, int k) {
		int i;
		for(i = 0; i < numeros.length; i++) {
			if (numeros[i] == k) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean buscaLinear_recursiva(int[] numeros, int k) {
		if(buscaLinear_recursivaAuxiliar(numeros, k, 0)==true) {
			return true;
		}
		return false;
	}

	private boolean buscaLinear_recursivaAuxiliar(int[] numeros, int k, int i) {
		if(i >= numeros.length) {
			return false;
		}else if(k==numeros[i]) {
			return true;
		}
		return buscaLinear_recursivaAuxiliar(numeros,k,i+1);	
	}
	
	@Override
	public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k) {
		int i, j;
		for (i = 0, j = numeros.length-1; i < j; i++, j--) {
			if (k==numeros[i]) {
				return true;
			} else if (k==numeros[j]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean buscaBinaria_iterativa(int[] numeros, int k) {
		int ini=0, fim=numeros.length-1, meio;
		while (ini<=fim) {
			meio = (ini+fim)/2;	
			if (k == numeros[meio]) {
				return true;
			} else if (k < numeros[meio]) {
				fim = meio-1;
			} else {
				ini = meio+1;
			}
		}
		return false;
	}

	@Override
	public boolean buscaBinaria_recursiva(int[] numeros, int k) {
		if(buscaBinaria_recursivaAuxiliar(numeros,k,0,numeros.length-1)==true) {
			return true;
		}
		return false;
	}
	
	private boolean buscaBinaria_recursivaAuxiliar(int[] numeros, int k, int ini, int fim) {
		if(ini>=fim) {
			return false;
		}
		
		int meio = (ini+fim)/2;
		
		if(k == numeros[meio]) {
			return true;
		} else if(k<numeros[meio]) {
			return buscaBinaria_recursivaAuxiliar(numeros,k,0,meio-1);
		} else {
			return buscaBinaria_recursivaAuxiliar(numeros,k,meio+1,fim);
		}
	}

}
