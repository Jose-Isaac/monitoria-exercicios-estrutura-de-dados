package br.edu.uepb.eda.atividade04;
import java.util.Scanner;
public class Projeto {

	public static void main(String[] args) throws Exception {

		      int opcao, numeroLivro;
		      Scanner sc = new Scanner(System.in);
		      System.out.println("Bem-vindo à Biblioteca da UEPB!\n");
		      System.out.println("Capacidade máxima de livros na estante = 40 livros!\n");

		        TabelaHash livrosCadastrados = new TabelaHash(40);

		        do {
		            System.out.println("MENU\n");
		            System.out.println("1 - Cadastrar um livro");
		            System.out.println("2 - Mostrar um livro cadastrado");
		            System.out.println("3 - Remover um livro cadastrado");
		            System.out.println("4 - Sair");

		            System.out.print("Escolha uma opção: ");
		            opcao = sc.nextInt();

		            switch (opcao) {
		                case 1:
		                    System.out.print("Digite o número do livro para cadastrá-lo: ");
		                    numeroLivro = sc.nextInt();
		                    livrosCadastrados.insert(numeroLivro);
		                    System.out.println("Livro cadastrado com sucesso!\n");
		                    break;
		                case 2:
		                    System.out.print("Digite o número do livro para mostrá-lo na estante: ");
		                    numeroLivro = sc.nextInt();
		                    try {
		                        Integer livroEncontrado = livrosCadastrados.search(numeroLivro);
		                        if (livroEncontrado != null && livroEncontrado.equals(numeroLivro)) {
		                            System.out.println("Livro encontrado na estante!\n");
		                        } else {
		                            System.out.println("Livro não encontrado na estante.\n");
		                        }
		                    } catch (Exception e) {
		                        System.out.println(e.getMessage());
		                    }
		                    break;

		                case 3:
		                    System.out.print("Digite o número do livro para removê-lo da estante: ");
		                    numeroLivro = sc.nextInt();
		                    livrosCadastrados.remove(numeroLivro);
		                    System.out.println("Livro removido da estante, se existir.\n");
		                    break;
		                case 4:
		                    System.out.println("Saindo do sistema. Até mais!");
		                    break;
		                default:
		                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.\n");
		            }

		        } while (opcao != 4);
		    }
		}

