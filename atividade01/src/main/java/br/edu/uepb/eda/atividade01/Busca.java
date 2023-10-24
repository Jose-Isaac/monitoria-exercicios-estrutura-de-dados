package br.edu.uepb.eda.atividade01;

public class Busca implements Busca_IF {
	@Override
	public int[] geraVetorNumericoOrdenado(int tamanho) {
		int[] arr = new int[tamanho];
		for(int i = 0; i < arr.length; i++) arr[i] = i;
		return arr;
	}

	@Override
	public boolean buscaLinear_iterativa(int[] numeros, int k) {
		for(int i = 0; i< numeros.length; i++){	      
			if(numeros[i] == k) return true;
	    }
		return false;
	}

	private boolean busca_auxBLR(int[] numeros, int k, int i) {
        if (i >= numeros.length) return false;
        else if (numeros[i] == k) return true;
        else return busca_auxBLR(numeros, k, i + 1);
    }

	@Override
	public boolean buscaLinear_recursiva(int[] numeros, int k) {
		return busca_auxBLR(numeros, k, 0);
	}
	
	@Override
	public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k){
		int M = numeros.length-1 / 2;
        for(int i = 0, j = numeros.length-1;i <= M && j > M; i++, j--) {
            if(numeros[i] == k || numeros[j] == k) return true;            
        }
        return false;
	}

	@Override
	public boolean buscaBinaria_iterativa(int[] numeros, int k) {   
	    int i = 0, j = numeros.length-1;
	    do{
	    	int m = i + (j - i) / 2;
	    	if(numeros[m] == k) return true;
	    	else if(numeros[m] < k) i = m + 1;
	    	else j = m - 1;
		} while(i <= j);		
	    return false;
	}
	
	private boolean busca_auxBR(int[] numeros, int k, int i, int j){
		if (i <= j) {
	        int m = i + (j - i) / 2;			
	        if (numeros[m] == k) return true;
	        else if (numeros[m] < k) return busca_auxBR(numeros, k, m + 1, j);
	        else return busca_auxBR(numeros, k, i, j - 1);
	    }
	    return false;
	}
	
	@Override
	public boolean buscaBinaria_recursiva(int[] numeros, int k) {   
		return busca_auxBR(numeros, k, 0, numeros.length - 1);
	}
}
