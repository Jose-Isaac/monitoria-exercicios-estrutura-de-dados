package br.edu.uepb.eda.atividade01;
public class Busca implements Busca_IF{


    public int[] geraVetorNumericoOrdenado(int tamanho) {

        int vetor [] = new int [tamanho];
        for (int  i = 0; i<tamanho;i++) {
            vetor [i] = i;
        }
        return vetor;
    }


    public boolean buscaLinear_iterativa(int[] numeros, int k) {

        boolean achar_num = false;
        for (int i = 0; i<numeros.length;i++) {
            if (numeros [i] == k) {
                achar_num=true;
            }


        }
        return achar_num;
    }



    public boolean buscaLinear_recursiva(int[] numeros, int k) {

        if (buscaLinear_recursivaAux(numeros,k,0)== true ) {
            return true;}

        else {
            return false;
        }

    }

    private boolean buscaLinear_recursivaAux(int [] numeros,int k, int indice) {


        if (indice >= numeros.length) {
            return false;
        }

        else if(numeros[indice]==k) {
            return true;
        }

        return buscaLinear_recursivaAux(numeros,k,indice+1);
    }

    public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k) {

        int esquerda = 0;
        int direita = numeros.length-1;

        while(esquerda<=direita) {
            if (numeros [esquerda]== k) {
                return true;
            }
            if (numeros[direita]==k) {
                return true;
            }
            esquerda++;
            direita --;
        }
        return false;

    }



    public boolean buscaBinaria_iterativa(int[] numeros, int k) {
        boolean achar_num =  false;
        int limite_inferior = 0;
        int limite_superior = numeros.length;
        int metade;

        while (limite_inferior<limite_superior) {
            metade = (limite_superior/2);
            if (k ==numeros[metade]) {
                return achar_num=true;
            }
            else {
                if (k<metade) {
                    limite_superior = metade -1;
                }
                else {
                    limite_inferior = metade + 1;
                }
            }

        }
        return achar_num;
    }


    public boolean BuscaBinária_iterativa(int[] numeros,int k){
        int menor = 0;
        int maior =  numeros.length - 1;
        boolean achar_num = false;

        while (menor <= maior) {
            int media = (maior + menor) / 2;

            int valorMeio = numeros[media];

            if(valorMeio < k)
                menor = media + 1;
            else if (valorMeio > k)
                maior = media - 1;
            else
                return achar_num=true;
        }
        return achar_num;
    }

    public boolean buscaBinaria_recursiva(int[] numeros, int k) {
        return buscaBinaria_recursivaAux(numeros, k, 0, numeros.length - 1);
    }

    private boolean buscaBinaria_recursivaAux(int[] numeros, int k, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (numeros[meio] == k) {
                return true;
            } else if (numeros[meio] < k) {
                return buscaBinaria_recursivaAux(numeros, k, meio + 1, fim);
            } else {
                return buscaBinaria_recursivaAux(numeros, k, inicio, meio - 1);
            }
        }

        return false;
    }}

