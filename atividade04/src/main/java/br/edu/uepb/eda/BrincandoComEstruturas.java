package br.edu.uepb.eda;

import br.edu.uepb.eda.atividade04.*;

import java.util.Arrays;

public class BrincandoComEstruturas {

	public static void main(String[] args) throws Exception {

		/*
		 * Deve aparecer tudo true na tela para funcionar
		 * Estou considerando que na árvore binária de busca não terão elementos
		 * repitidos
		 */

		System.out.println("# BRINCANDO COM BST #\n");
		BST_IF minhaArvore = new BST();

		minhaArvore.insert(8);
		System.out.println(minhaArvore.search(8) == 8);
		System.out.println(minhaArvore.isComplete());

		minhaArvore.insert(10);
		System.out.println(minhaArvore.search(10) == 10);
		System.out.println(!minhaArvore.isComplete());

		minhaArvore.insert(6);
		System.out.println(minhaArvore.search(6) == 6);
		System.out.println(minhaArvore.isComplete());

		minhaArvore.insert(2);
		System.out.println(minhaArvore.search(2) == 2);
		System.out.println(!minhaArvore.isComplete());

		minhaArvore.insert(7);
		System.out.println(minhaArvore.search(7) == 7);
		System.out.println(!minhaArvore.isComplete());

		minhaArvore.insert(9);
		System.out.println(minhaArvore.search(9) == 9);
		System.out.println(!minhaArvore.isComplete());

		minhaArvore.insert(11);
		System.out.println(minhaArvore.search(11) == 11);
		System.out.println(minhaArvore.isComplete());

		// Será lançada uma exceção pois não encontrará o 16
		// System.out.println(minhaArvore.search(16) == 16);

		System.out.println(
				Arrays.toString(minhaArvore.preOrder()).equals(Arrays.toString(new int[] { 8, 6, 2, 7, 10, 9, 11 })));

		System.out.println(
				Arrays.toString(minhaArvore.order()).equals(Arrays.toString(new int[] { 2, 6, 7, 8, 9, 10, 11 })));

		System.out.println(
				Arrays.toString(minhaArvore.postOrder()).equals(Arrays.toString(new int[] { 2, 7, 6, 9, 11, 10, 8 })));

		System.out.println("\n#Brincando com TABELA HASH #\n");
		TabelaHash_IF minhaTabelaHash = new TabelaHash(7);

		int i;
		for (i = 1; i <= 25; i++) {
			minhaTabelaHash.insert(i);
		}

		System.out.println(minhaTabelaHash.search(21) == 21);
		System.out.println(minhaTabelaHash.search(7) == 7);
		System.out.println(minhaTabelaHash.search(15) == 15);

		minhaTabelaHash.remove(1);
		minhaTabelaHash.remove(9);
		minhaTabelaHash.remove(18);
		minhaTabelaHash.remove(24);

		// Será lançada uma exceção pois não encontrará mais o 18
		// System.out.println(minhaTabelaHash.search(18) == 18);

		// Printa como está a tabela hash
		// System.out.println(minhaTabelaHash.print());

		System.out.println(
				minhaTabelaHash.print().equals("0: 21, 14, 7, \n1: 22, 15, 8, \n2: 23, 16, 2, \n3: 17, 10, 3,"
						+ " \n4: 25, 11, 4, \n5: 19, 12, 5, \n6: 20, 13, 6, \n"));

	}

}
