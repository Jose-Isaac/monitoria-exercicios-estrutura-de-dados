package br.edu.uepb.eda.atividade04;
public class Projeto {

    public static void main(String[] args) {
        BST bstAlunos = new BST();

        Scanner scanner = new Scanner(System.in);

       
        int opcao;
        do {
            System.out.println("\n=== Cadastro de Alunos ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Buscar Aluno");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Exibir Lista de Alunos (em ordem)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarAluno(bstAlunos, scanner);
                    break;
                case 2:
                    buscarAluno(bstAlunos, scanner);
                    break;
                case 3:
                    exibirAlunos(bstAlunos);
                    break;
            }
        } while (opcao != 0);

        System.out.println("Encerrando o programa.");
    }

    private static void cadastrarAluno(BST bst, Scanner scanner) {
        System.out.print("Digite o número de matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 

       
        try {
            bst.search(matricula);
            System.out.println("Aluno com matrícula " + matricula + " já cadastrado.");
        } catch (Exception e) {
            
            bst.insert(matricula);
            System.out.println("Aluno cadastrado com sucesso.");
        }
    }

    private static void buscarAluno(BST bst, Scanner scanner) {
        System.out.print("Digite o número de matrícula do aluno: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); 

        try {
            bst.search(matricula);
            System.out.println("Aluno com matrícula " + matricula + " encontrado.");
        } catch (Exception e) {
            System.out.println("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }


    private static void exibirAlunos(BST bst) {
        int[] matriculas = bst.order();
        System.out.println("\nLista de Alunos (em ordem):");
        for (int matricula : matriculas) {
            System.out.println("Matrícula: " + matricula);
        }
    }
    }
    
    

