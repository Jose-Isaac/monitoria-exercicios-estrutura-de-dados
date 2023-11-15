package atividade04;

import java.util.Scanner;
import java.util.Random;

public class Projeto {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int resp, senha, divisorias;
		Random geradorAleatorio = new Random();
		System.out.printf(
				"Bem-vindo ao sistema de estacionamento do shopping! Primeiro, informe a quantidade de divisórias do estacionamento:\n");
		divisorias = sc.nextInt();
		TabelaHash_IF estacionamento = new TabelaHash(divisorias);
		do {
			System.out.printf("\nSelecione a operação que deseja fazer:");
			System.out.printf("\n[1] Adicionar carro no estacionamento\n[2] Remover carro do estacionamento\n[3] Buscar carro no estacionamento\n[4] Mostrar situação atual do estacionamento\n[5] sair\n");
			resp = sc.nextInt();
			switch (resp) {
			case 1:
				senha = geradorAleatorio.nextInt(1000000);
				try {
					while (estacionamento.search(senha) == senha) {
						senha = geradorAleatorio.nextInt(1000000);
					}
				} catch (Exception e) {
					System.out.printf("\nA senha %d é válida!", senha);
				}
				estacionamento.insert(senha);
				System.out.printf("\nCarro registrado no sistema!\n");
				break;
			case 2:
				System.out.printf("\nQual a senha do carro que deseja remover? ");
				int removido = sc.nextInt();
				try {
					estacionamento.remove(removido);
					System.out.printf("Carro removido do sistema!\n");
				} catch (Exception e) {
					System.out.printf("Não foi possível realizar a operação porque o carro não consta no sistema!\n");
				}
				break;
			case 3:
				System.out.printf("\nQual a senha do carro que deseja buscar? ");
				int buscado = sc.nextInt();
				try {
					if (estacionamento.search(buscado) == buscado) {
						System.out.printf("O carro está no estacionamento na divisória %d.\n", buscado % divisorias);
					}
				} catch (Exception e) {
					System.out.printf("O carro não consta no sistema!\n");
				}
				break;
			case 4:
				System.out.printf("\n\nEssa é a situação atual do estacionamento:\n");
				System.out.println(estacionamento.print());
				break;
			case 5:
				System.out.println("\nObrigado por utilizar nossos serviços. Até mais!");
				break;
			default:
				System.out.println("\nOperação inexistente! Tente outra vez.");
				break;
			}
		} while (resp != 5);
	}
}

/*
 * Exemplo de descrição de problema que tentaremos solucionar com Tabela Hash:
 * um shopping center de uma cidade metropolitana precisa de um programa que
 * organize o seu estacionamento, que diaramente recebe milhares de carros. A
 * ideia é que o estacionamento seja dividido em partes, de modo que as
 * divisórias fiquem com uma quantidade parecida de veículos. Cada carro que
 * entrar no estacionamento receberá uma ficha com um número indicado, para que
 * o seu motorista, ao finalizar suas compras, venha buscá-lo e o administrador
 * possa dar baixa nele.
 */
