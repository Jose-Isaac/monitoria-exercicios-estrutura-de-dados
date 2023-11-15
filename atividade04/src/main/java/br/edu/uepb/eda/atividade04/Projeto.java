package atividade04;
import java.util.Scanner;
public class Projeto {

	public static void main(String[] args) throws Exception {
		
/* A bodega do vovô precisa ser mais organizada e prática, e para isso, usaremos a tabelaHash 
 * para proporcionar um acesso mais rápido a fim de que o vovô descanse mais.
 * Assim, ele não precisa verificar os produtos, basta ver. 
 * 
 * 
 * *\
 */
	
	int op,num_cadas;
	Scanner leitor = new Scanner (System.in);
	System.out.println("BEM-VINDO(A)A BODEGA DO VOVÔ!\n\nQuantidade máxima suportada em estoque = 30 produtos! ");
	TabelaHash cadastrados = new TabelaHash(30);
	System.out.println("MENU\n\n1 - Digite o número do produto para cadastrá-lo;"
			+ "\n2 - Digite o número do produto para mostrá-lo na tabela;"
			+ "\n3 - Digite o número do produto para removê-lo;"
			+ "\n4 - Sair.");
	op = leitor.nextInt();
	
	while (op!=4) {
	if (op==1) {
		System.out.println("Digite o número do produto: ");
		num_cadas = leitor.nextInt();
		cadastrados.insert(num_cadas);
		System.out.println(cadastrados.print());
		System.out.println("MENU\n\n1 - Digite o número do produto para cadastrá-lo;"
				+ "\n2 - Digite o número do produto para mostrá-lo na tabela;"
				+ "\n3 - Digite o número do produto para removê-lo;"
				+ "\n4 - Sair.");
		op = leitor.nextInt();
	}
	
	if (op==2) {
		System.out.println("Digite o número do produto: ");
		num_cadas = leitor.nextInt();
		cadastrados.search(num_cadas);
		System.out.println(cadastrados.print());
		System.out.println("MENU\n\n1 - Digite o número do produto para cadastrá-lo;"
				+ "\n2 - Digite o número do produto para mostrá-lo na tabela;"
				+ "\n3 - Digite o número do produto para removê-lo;"
				+ "\n4 - Sair.");
		op = leitor.nextInt();
	}
	
	if (op==3) {
		System.out.println("Digite o número do produto: ");
		num_cadas = leitor.nextInt();
		cadastrados.remove(num_cadas);
		System.out.println(cadastrados.print());
		System.out.println("MENU\n\n1 - Digite o número do produto para cadastrá-lo;"
				+ "\n2 - Digite o número do produto para mostrá-lo na tabela;"
				+ "\n3 - Digite o número do produto para removê-lo;"
				+ "\n4 - Sair.");
		op = leitor.nextInt();
		
	}
	
	if (op==4) {
		System.out.println("");
		break;
	}
	
	}}

}
