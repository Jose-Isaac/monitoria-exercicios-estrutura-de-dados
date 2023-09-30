package br.edu.uepb.eda.atividade01;

public class Busca implements Busca_IF{
    @Override
    public int[] geraVetorNumericoOrdenado(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i * 2; // números pares em ordem crescente
        }
        return vetor;
    }

    @Override
    public boolean buscaLinear_iterativa(int[] numeros, int k) {
        for (int numero : numeros) {
            if (numero == k) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscaLinear_recursiva(int[] numeros, int k) {
        return buscaLinearRecursiva(numeros, k, 0);
    }

    private boolean buscaLinearRecursiva(int[] numeros, int k, int index) {
        if (index >= numeros.length) {
            return false;
        }
        if (numeros[index] == k) {
            return true;
        }
        return buscaLinearRecursiva(numeros, k, index + 1);
    }

    @Override
    public boolean buscaBinaria_iterativa(int[] numeros, int k) {
        int esquerda = 0;
        int direita = numeros.length - 1;
        
        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            
            if (numeros[meio] == k) {
                return true;
            }
            
            if (numeros[meio] < k) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        
        return false;
    }

    @Override
    public boolean buscaBinaria_recursiva(int[] numeros, int k) {
        return buscaBinariaRecursiva(numeros, k, 0, numeros.length - 1);
    }

    private boolean buscaBinariaRecursiva(int[] numeros, int k, int esquerda, int direita) {
        if (esquerda > direita) {
            return false;
        }
        
        int meio = esquerda + (direita - esquerda) / 2;
        
        if (numeros[meio] == k) {
            return true;
        } else if (numeros[meio] < k) {
            return buscaBinariaRecursiva(numeros, k, meio + 1, direita);
        } else {
            return buscaBinariaRecursiva(numeros, k, esquerda, meio - 1);
        }
    }
}
