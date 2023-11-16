package br.edu.uepb.eda.atividade04;

public class Projeto_BST {

    protected Projeto_Node root;

    public Projeto_BST () { this.root = null; }

    public boolean isNIL() {
        return (this.root == null);}

    public void insert(String element) {
        this.root = insert_recursive(this.root, element);
    }
    public Projeto_Node insert_recursive (Projeto_Node node, String element) {
        if (node == null) {
            node = new Projeto_Node(element);
            return node;
        } else if (compare(node.name, element).equals("")) {
            node.copies++;
        } else if (compare(node.name, element).equals(element)) {
            node.left = insert_recursive(node.left, element);
        } else {
            node.right = insert_recursive(node.right, element);
        }
        return node;
    }

    public String compare (String x, String y) { // retorna o "menor"
        int c1, c2;
        for(int i = 0; i < x.length() && i < y.length(); i++) {
            c1 = (int) x.toLowerCase().charAt(i);
            c2 = (int) y.toLowerCase().charAt(i);

            if (c1 < c2) {
                return x;
            } else if (c2 < c1) {
                return y;
            }
        }
        if(x.length() < y.length()) { // trata casos como x = "aaaa" / y = "aaa"
            return x;
        } else if (x.length() < y.length()) {
            return y;
        } else {
            return "";
        }
    }

    public void remove(String element) {
        this.root = remove_recursive(this.root, element);
    }
    public Projeto_Node remove_recursive (Projeto_Node node, String element) {

        if (node == null) {
            return node;
        } else if (compare(node.name, element).equals(element)) {
            node.left = remove_recursive(node.left, element);
            return node;
        } else if (compare(node.name, element).equals(node.name)) {
            node.right = remove_recursive(node.right, element);
            return node;
        }

        if (node.copies > 1) {
            node.copies--;
            return node;
        }
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        } else {
            Projeto_Node parent = node;
            Projeto_Node sucessor = node.right;

            while (sucessor.left != null) {
                parent = sucessor;
                sucessor = sucessor.left;
            }
            if (parent != node) {
                parent.left = sucessor.right;
            } else {
                parent.right = sucessor.right;
            }
            node.name = sucessor.name;
            return node;
        }
    }

    public String search(String element) throws Exception {
        String result = search_recursive(this.root, element);
        if (result == null) {
            throw new Exception ("Não está na árvore");
        } return result;
    }
    public String search_recursive (Projeto_Node node, String element) {
        if (node == null) {
            return null;
        } else if (node.name.equals(element)) {
            return element;
        } else if (compare(node.name, element).equals(element)) {
            return search_recursive(node.left, element);
        } else {
            return search_recursive(node.right,element);
        }
    }

    public String[] order() {
        String[] order = new String [count_nodes(root)];
        order(root, order, 0);
        return order;
    }
    public int order (Projeto_Node node, String[] list, int i) {
        if (node != null) {
            i = order(node.left, list, i);
            list[i++] = node.copies + " " + node.name;
            return order(node.right, list, i);
        } return i;
    }

    public int count_nodes (Projeto_Node node) {
        if (node == null) {
            return 0;
        } return 1 + count_nodes(node.left) + count_nodes(node.right);
    }
    public int altura (Projeto_Node node) {
        if (node == null || node.left == null && node.right == null) {
            return 0; // inicia do 0
        } else {
            int h_left = altura(node.left);
            int h_right = altura(node.right);

            if (h_left > h_right) {
                return h_left + 1;
            } else {
                return h_right + 1;
            }
        }
    }
}
