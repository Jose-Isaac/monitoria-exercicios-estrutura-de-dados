package br.edu.uepb.eda.atividade04;

import java.util.Scanner;
import java.util.Random;

public class Projeto {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int resp, senha, divisorias;
		Random geradorAleatorio = new Random();
		System.out.printf(
				"Sistema de armazenamento de produtos, insira o número de departamentos:\n");
		divisorias = sc.nextInt();
		TabelaHash_IF estacionamento = new TabelaHash(divisorias);
		do {
			System.out.printf("\nEscolha uma opção:");
			System.out.printf("\n(1) Adicionar produto novo.\n(2) Remover produto.\n(3) Procurar produto.\n(4) Exibir armazenamento.\n(5) Sair.\n");
			resp = sc.nextInt();
			switch (resp) {
			case 1:
				senha = geradorAleatorio.nextInt(1000000);
				try {
					while (estacionamento.search(senha) == senha) {
						senha = geradorAleatorio.nextInt(1000000);
					}
				} catch (Exception e) {
					System.out.printf("\nO Código de barras %d Foi validado!", senha);
				}
				estacionamento.insert(senha);
				System.out.printf("\nProduto Armazenado!\n");
				break;
			case 2:
				System.out.printf("\nInsira o código de barra do produto que deseja remover? ");
				int removido = sc.nextInt();
				try {
					estacionamento.remove(removido);
					System.out.printf("Produto retirado!\n");
				} catch (Exception e) {
					System.out.printf("Produto não encontrado!\n");
				}
				break;
			case 3:
				System.out.printf("\nInsira o código de barra do produto que deseja procurar: ");
				int buscado = sc.nextInt();
				try {
					if (estacionamento.search(buscado) == buscado) {
						System.out.printf("Produto localizado no departamento %d.\n", buscado % divisorias);
					}
				} catch (Exception e) {
					System.out.printf("Este produto não está armazenado!\n");
				}
				break;
			case 4:
				System.out.printf("\n\nArmazém:\n");
				System.out.println(estacionamento.print());
				break;
			case 5:
				System.out.println("\nPrograma encerrado.");
				break;
			default:
				System.out.println("\nOperação inexistente! Tente de novo.");
				break;
			}
		} while (resp != 5);
	}
}
