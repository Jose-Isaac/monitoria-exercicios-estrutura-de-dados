package br.edu.uepb.eda.atividade04;

public class ArvorePV<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private No raiz;

    private class No {
        Key key;
        Value value;
        No left, right;
        int size;
        boolean cor;

        public No(Key key, Value value, int size, boolean cor) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.cor = cor;
        }
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("A chave não pode ser nula.");
        }
        raiz = put(raiz, key, value);
        raiz.cor = BLACK;
    }

    private No put(No h, Key key, Value value) {
        if (h == null) {
            return new No(key, value, 1, RED);
        }

        int c = key.compareTo(h.key);

        if (c < 0) {
            h.left = put(h.left, key, value);
        } else if (c > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotacaoLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotacaoRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.size = size(h.left) + size(h.right) + 1;

        return h;
    }

    private No rotacaoLeft(No h) {
        No x = h.right;
        h.right = x.left;
        x.left = h;
        x.cor = h.cor;
        h.cor = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private No rotacaoRight(No h) {
        No x = h.left;
        h.left = x.right;
        x.right = h;
        x.cor = h.cor;
        h.cor = RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(No h) {
        h.cor = RED;
        h.left.cor = BLACK;
        h.right.cor = BLACK;
    }

    private int size(No x) {
        if (x == null) return 0;
        return x.size;
    }

    private boolean isRed(No x) {
        if (x == null) return false;
        return x.cor == RED;
    }
    
    // Método de busca
    public Value get(Key key) {
        return get(raiz, key);
    }

    private Value get(No x, Key key) {
        while (x != null) {
            int c = key.compareTo(x.key);
            if (c < 0) {
                x = x.left;
            } else if (c > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }    
}