package br.edu.uepb.eda.atividade04;

import java.util.Random;
import java.util.Scanner;

public class Projeto {
	public static int andar(int posicaoAtual, boolean naBeira) {
		Scanner sc = new Scanner(System.in);
		int novaPosicao;
		String fala;
		
		if (naBeira && posicaoAtual > 0) {
			int esquerda = posicaoAtual - 1;
			fala = "Andar para a esquerda(" + esquerda +")? ";
			
			System.out.print(fala);
			novaPosicao = sc.nextInt();
			while (novaPosicao != esquerda) {
				System.out.println("Valor indisponível!");
				System.out.print(fala);
				novaPosicao = sc.nextInt();
			}
		} else if (naBeira && posicaoAtual < 0) {
			int direita = posicaoAtual + 1;
			fala = "Andar para a direita(" + direita + ")? ";
			
			System.out.print(fala);
			novaPosicao = sc.nextInt();
			while (novaPosicao != direita) {
				System.out.println("Valor indisponível!");
				System.out.print(fala);
				novaPosicao = sc.nextInt();
			}
		} else {
			int esquerda = posicaoAtual - 1;
			int direita = posicaoAtual + 1;
			fala = "Andar para a esquerda(" + esquerda +") ou direita(" + direita + ")? ";
			
			System.out.print(fala);
			novaPosicao = sc.nextInt();
			while (novaPosicao != esquerda && novaPosicao != direita) {
				System.out.println("Valor indisponível!");
				System.out.print(fala);
				novaPosicao = sc.nextInt();
			}
		}
		
		return novaPosicao;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		BST mapa = new BST();
		int posicaoAtual = 0;
		
		System.out.print("Qual será o limite da ilha (Quanto maior, mais díficil)?");
		int limiteIlha = sc.nextInt();
		while (limiteIlha <= 0) {
			System.out.println("Valor indisponível!");
			System.out.print("Qual será o limite da ilha (Quanto maior, mais díficil)?");
			limiteIlha = sc.nextInt();
		}
		
		int localTesouro = random.nextInt((limiteIlha * (-1)), limiteIlha + 1);
		while (localTesouro == 0) {
			localTesouro = random.nextInt((limiteIlha * (-1)), limiteIlha + 1);
		}
		mapa.insert(0); // Começo (root)
		
		System.out.println("\nVocê está em busca de um tesouro na ilha de dados, boa sorte!");
		while (posicaoAtual != localTesouro) {
			if (posicaoAtual == limiteIlha || posicaoAtual == (limiteIlha * (-1))) {
				System.out.println("Acho que você perdeu um pouco a noção de espaço e parou no mar...");
				
				posicaoAtual = andar(posicaoAtual, true);
				mapa.insert(posicaoAtual);
			} else {
				posicaoAtual = andar(posicaoAtual, false);
				mapa.insert(posicaoAtual);
			}
		}
		System.out.println("\nParabéns, você encontrou um baú cheio de Listas Encadeadas! Bom trabalho!");
	}

}
