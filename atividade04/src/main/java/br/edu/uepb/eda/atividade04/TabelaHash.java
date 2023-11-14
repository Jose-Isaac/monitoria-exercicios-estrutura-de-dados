package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;
import java.util.List;

public class TabelaHash implements TabelaHash_IF {
	private int size;
	private List<List<Integer>> frame; // tabela

	public TabelaHash(int size) {
		this.size = size;
		this.frame = new ArrayList<>(size);
    
		for (int i = 0; i < size; i++) {
			frame.add(new ArrayList<>());
		}
	}

	private int hash(int element) {
		return element % size;
	}

	@Override
	public void insert(Integer element) {
		int index = hash(element);
		frame.get(index).add(0,element);
	}

	@Override
	public void remove(Integer element) throws Exception {
		int index = hash(element);
		List<Integer> list = frame.get(index);

		if (list.contains(element)) {
			list.remove(Integer.valueOf(element));
		} else {
			throw new Exception("Elemento não encontrado na tabela.");
		}
	}

	@Override
	public int search(Integer element) throws Exception {
		int index = hash(element);
		List<Integer> list = frame.get(index);

		if (list.contains(element)) {
			return element;
		} else {
			throw new Exception("Elemento não encontrado na tabela.");
		}
	}

	@Override
	public String print() {
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < size; i++) {
			result.append(i).append(": ");
			if(!frame.get(i).isEmpty()){
        		for (int j = 0; j < frame.get(i).size(); j++) {
          			result.append(frame.get(i).get(j));
          			if (j < frame.get(i).size() - 1) {
            			result.append(", ");
         	 		}
        		}
      		}
			result.append("\n");
		}
		return result.toString();
	}
}