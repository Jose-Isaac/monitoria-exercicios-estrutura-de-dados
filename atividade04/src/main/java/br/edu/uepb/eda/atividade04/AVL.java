package br.edu.uepb.eda.atividade04;

public class AVL {
    // Classe interna para representar um nó da árvore AVL
    static class Node {
        int key;
        Node left, right;
        int height;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    // Método para obter a altura de um nó
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Método para calcular o fator de balanceamento de um nó
    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Método para retornar o máximo de dois números inteiros
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Método para realizar uma rotação à esquerda
    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node aux = y.left;

        // Realiza a rotação
        y.left = x;
        x.right = aux;

        // Atualiza as alturas
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // root interno
    private Node root = null;

    // Método para realizar uma rotação à direita
    private Node rotateRight(Node y) {
        Node x = y.left;
        Node aux = x.right;

        // Realiza a rotação
        x.right = y;
        y.left = aux;

        // Atualiza as alturas
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Método para inserir uma chave em uma árvore AVL
    public void insert(int key) {
        root = insert(root, key);
    }

    // Método privada de inserção
    private Node insert(Node root, int key) {
        
        if (root == null) {
        	return new Node(key);
        }            

        else if (key < root.key) {
        	root.left = insert(root.left, key);
        }
            
        else if (key > root.key) {
        	root.right = insert(root.right, key);
        }
            
        else {
        	return root;
        }
        
        root.height = 1 + max(height(root.left), height(root.right));
        
        int balance = getBalance(root);

        // Esquerda-Esquerda (LL)
        if (balance > 1 && key < root.left.key) {
        	return rotateRight(root);
        }            

        // Direita-Direita (RR)
        else if (balance < -1 && key > root.right.key) {
        	 return rotateLeft(root);
        }           

        // Esquerda-Direita (LR)
        else if (balance > 1 && key > root.left.key) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Direita-Esquerda (RL)
        else if (balance < -1 && key < root.right.key) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        // Nenhum desequilíbrio, retorna o nó sem alterações
        return root;
    }
    
    public int getHeight() {
    	return height(root);
    }
    
    public Node getRoot() {
    	return root;
    }

    // Método para imprimir a árvore em ordem
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    // Método para imprimir a árvore em preordem
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Método para imprimir a árvore em posordem
    public void posOrder(Node root) {
        if (root != null) {
            posOrder(root.left);
            posOrder(root.right);
            System.out.print(root.key + " ");
        }
    }
}