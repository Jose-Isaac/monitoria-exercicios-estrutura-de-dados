package br.edu.uepb.eda.atividade04;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Scanner;


public class Projeto {
    public static void main(String[] args) throws Exception {
        TabelaHash cartelaBingo = new TabelaHash(5);
        Scanner scan = new Scanner(System.in);

        int quantidadeNumeros = 24;
        int quantidadeNumerosSorteio = 65;
        int valorMinimo = 1;
        int valorMaximo = 75;

        Set<Integer> cartela = new HashSet<>();
        Set<Integer> sorteio = new HashSet<>();
        Set<Integer> restante = new HashSet<>();
        Random random = new Random();

        while (cartela.size() < quantidadeNumeros) {
            int numeroSorteado = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
            cartela.add(numeroSorteado);

        }

        for (Integer integer : cartela) {
            cartelaBingo.insert(integer);
            restante.add(integer);
        }

        System.out.println("\n\nSua cartela do Bingo\n");
        System.out.println(cartelaBingo.print());
        
        while (sorteio.size() < quantidadeNumerosSorteio) {
            int sorteado = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
            sorteio.add(sorteado);
        }

        System.out.println("Começando o sorteio: ");

        for (Integer i : sorteio) {
            cartelaBingo.remove(i);
        }

        System.out.println("\nQuantas restaram:\n");
        System.out.println(cartelaBingo.print());

        System.out.printf("Marcou todas?: ");
        String op = scan.nextLine().toUpperCase();

        if (op.equals("S")) {
            System.out.printf("Parabéns você venceu!\n");
        } else {
            System.out.printf("Fracassou!");
        }       
    }    
}
