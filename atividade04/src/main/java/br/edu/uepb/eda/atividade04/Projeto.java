package br.edu.uepb.eda.atividade04;

import java.util.Scanner;

public class Projeto {
	
	public static int numCtt(String[] arrayNomes, int hashCodeNomeUpCs) {
		
		int i;
		for(i = 0; i < arrayNomes.length; i++) {
			if(hashCodeNomeUpCs == arrayNomes[i].toUpperCase().hashCode()) {
				return i+1;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		
		// PROJETO: BUSCAR CONTATO EM LISTA PELO NOME UTILIZANDO TABELA HASH
		
		/*
		 * ALGUMAS OBSERVAÇÕES SOBRE O PROJETO
		 * 
		 * 1 - abstrai algumas coisas como por exemplo, uma agenda precisa de número telefônico,
		 * porém apenas considerei uma busca de nomes
		 * 
		 * 2 - o projeto usa tabela hash para colocar um array de nomes (Como dito na observação 1,
		 * poderia ser um array da classe contato, por exemplo, mas abstrai isso), que seria uma busca
		 * O(n), em uma busca O(1)
		 * 
		 * 3 - a busca ocorre de maneira não Case-sensitive, podendo pesquisar, por exemplo, o nome
		 * paulo por paulo, Paulo, PAULO, etc
		 * 
		 * 4 - no final ocorre uma busca O(n), que seria o processo normalmente, mas apenas utilizei
		 * para deixar o projeto mais completo mostrando o exato lugar em que a palavra está no array
		 * inicial totalmente desorganizado, porém fiz isso de forma que o argumento passado para a
		 * função saísse da tabela hash
		 * 
		 * 5 - em situações de um projeto mais complexo eu, obviamente, evitaria isso. Porém, nesse caso,
		 * optei por utilizar por causa da forma que a classe TabelaHash está implementada, uma forma não
		 * adaptada ao que propõe o projeto
		 * 
		 * 6 - também para evitar extender o código e focar apenas na busca, pedi para o chatGPT criar um
		 * array com 100 nomes própios, simulando uma longa lista de contatos, e também não coloquei métodos
		 * para remoção e adição de novos contatos, como disse, foquei na busca
		 */
		
		Scanner scan = new Scanner(System.in);
		
		// Array de 100 nomes
		String[] nomesContato = new String[]{
			    "Ana", "Beto", "Carla", "Daniel", "Eva", "Fernando", "Gabriela", "Henrique", "Inês", "João",
			    "Karen", "Lucas", "Mariana", "Nuno", "Olga", "Paulo", "Quico", "Raquel", "Sara", "Tiago",
			    "Úrsula", "Vera", "Wilson", "Xavier", "Yara", "Zara", "Abel", "Bianca", "Caio", "Débora",
			    "Eduardo", "Fátima", "Gustavo", "Helena", "Ícaro", "Júlia", "Kiko", "Lara", "Miguel", "Natália",
			    "Olívia", "Pedro", "Queila", "Ricardo", "Sofia", "Túlio", "Ulisses", "Valentina", "Wagner", "Xena",
			    "Yasmin", "Zacarias", "Adriana", "Bernardo", "Carolina", "Diego", "Eliana", "Fábio", "Gisele", "Hugo",
			    "Isabela", "Jorge", "Kátia", "Leandro", "Márcia", "Nelson", "Oscar", "Patrícia", "Quintino", "Rafaela",
			    "Samuel", "Tatiana", "Ubirajara", "Valéria", "Washington", "Xisto", "Yuri", "Zuleide", "Amanda", "Bruno",
			    "Camila", "Diogo", "Elisa", "Fernanda", "Gustavo", "Heloísa", "Igor", "Jéssica", "Karina", "Leonardo",
			    "Mariana", "Natalia", "Otávio", "Priscila", "Quênia", "Rodrigo", "Sandra", "Thiago", "Ulisses", "Vitória"
		};
		
		// Criação da agenda em tabela hash
		TabelaHash_IF agendaContatos = new TabelaHash(23);
		
		for(String nome: nomesContato) {
			agendaContatos.insert(nome.toUpperCase().hashCode());
		}

		// Imprimir nomes dos contatos em ordem do array
		System.out.println("# LISTA DE CONTATO DESORGANIZADA #\n");
		int i = 0;
		for(String nome: nomesContato) {
			System.out.printf(i+1 + " - " + nome + " ||| ");
			
			i++;
			
			if(i % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		// Imprimir tabela hash, de hashCode dos contatos
		System.out.println("# TABELA HASH DOS HASHCODES DA LISTA DE CONTATO #");
		System.out.println(agendaContatos.print());
		System.out.println();
		
		// Utilizando a tabela hash para procurar contatos a tempo médio O(1)
		System.out.println("# UTILIZANDO A TABELA HASH PARA BUSCAR CONTATO #\n");
		int loop = 1;
		String procurar;
		while(loop == 1) {
			System.out.println("Digite um nome para procurar na agenda ('stop' para parar):");
			procurar = scan.nextLine();
			
			if(procurar.equals("stop")) {
				System.out.println("PROGRAMA FINALIZADO");
				loop = 0;
			}else {
				
				try {
					
					// O método de procura na tabela hash tem custo médio O(1)
					/*
					 * Porém a função "numCtt" é custo O(n) apenas para o projeto ficar mais completo
					 * e mostrar a posição do nome na lista de nomes desorganizados
					 */
					
					int posCtt = numCtt(nomesContato, agendaContatos.search(procurar.toUpperCase().hashCode()));
					System.out.println("CONTATO NA AGENDA!");
					System.out.println("POSIÇÃO DO CONTATO: " + posCtt + "\n");
					
				} catch (Exception e) {
					System.out.println("CONTATO NÃO ESTÁ NA AGENDA!\n");
				}
			
			}
		}
		
		scan.close();
		
	}

}
