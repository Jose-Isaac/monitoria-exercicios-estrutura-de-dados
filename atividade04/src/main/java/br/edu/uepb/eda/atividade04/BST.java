package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;
import java.util.List;

public class BST implements BST_IF {
    private Integer data;
    private BST left, right;

    public BST() {
        this.data = null;
        this.left = this.right = null;
    }

    @Override
    public void insert(Integer element) {
        if (data == null) {
            data = element;
        } else {
            if (element < data) {
                if (left == null) {
                    left = new BST();
                }
                left.insert(element);
            } else if (element > data) {
                if (right == null) {
                    right = new BST();
                }
                right.insert(element);
            }
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (data == null) {
            throw new Exception("Elemento não encontrado");
        }
        if (element.equals(data)) {
            return data;
        } else if (element < data && left != null) {
            return left.search(element);
        } else if (element > data && right != null) {
            return right.search(element);
        }
        throw new Exception("Elemento não encontrado");
    }

    @Override
    public int[] preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderRec(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrderRec(List<Integer> result) {
        if (data != null) {
            result.add(data);
            if (left != null) {
                left.preOrderRec(result);
            }
            if (right != null) {
                right.preOrderRec(result);
            }
        }
    }

    @Override
    public int[] order() {
        List<Integer> result = new ArrayList<>();
        orderRec(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void orderRec(List<Integer> result) {
        if (left != null) {
            left.orderRec(result);
        }
        if (data != null) {
            result.add(data);
        }
        if (right != null) {
            right.orderRec(result);
        }
    }

    @Override
    public int[] postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderRec(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void postOrderRec(List<Integer> result) {
        if (left != null) {
            left.postOrderRec(result);
        }
        if (right != null) {
            right.postOrderRec(result);
        }
        if (data != null) {
            result.add(data);
        }
    }

    @Override
    public boolean isComplete() {
        int index = 0;
        int count = countNodes();
        return isCompleteRec(index, count);
    }

    private boolean isCompleteRec(int index, int count) {
        if (index >= count) {
            return false;
        }
        boolean leftComplete = (left == null) || left.isCompleteRec(2 * index + 1, count);
        boolean rightComplete = (right == null) || right.isCompleteRec(2 * index + 2, count);
        return leftComplete && rightComplete;
    }

    private int countNodes() {
        int count = 0;
        if (data != null) {
            count = 1;
            if (left != null) {
                count += left.countNodes();
            }
            if (right != null) {
                count += right.countNodes();
            }
        }
        return count;
    }
}
