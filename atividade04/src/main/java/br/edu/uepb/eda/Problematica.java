package br.edu.uepb.eda;

import java.util.Scanner;

public class Problematica {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        BSTContato listaTelefonica = new BSTContato();
        int op=3;
        String nome;
        int numero = 0;
        while(op!=0){
            System.out.println("Digite 1 para adicionar um contato a lista\nDigite 2 para buscar um contato na lista\nDigite qualquer outra coisa para parar");
            op = scan.nextInt();
            switch (op){
                case 1:
                    System.out.print("Digite o nome do Contato: ");
                    nome = scan.nextLine();
                    scan.nextLine();
                    System.out.print("Digite o número do Contato: ");
                    numero = scan.nextInt();
                    listaTelefonica.insert(new Contato(nome,numero));
                    break;
                case 2:
                    System.out.print("Digite o nome do Contato: ");
                    nome = scan.nextLine();
                    scan.nextLine();
                    nome = listaTelefonica.search(new Contato(nome,0)).nome;
                    if (nome == null){
                        System.out.println("Pessoa não encontrado!");
                    }else {
                        System.out.println("Pessoa "+nome+" está na lista!");
                    };
                    break;
                default:
                    op = 0;
                    break;
            }
        }
    }
}
