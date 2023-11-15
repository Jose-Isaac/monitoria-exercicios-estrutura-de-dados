package atividade04;

import java.util.Arrays;

public class BrincandoComEstruturas {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Brincando com BST...");
		BST_IF minhaArvore = new BST();
		minhaArvore.insert(8);
		System.out.println(minhaArvore.isComplete());
		System.out.println(Arrays.toString(minhaArvore.preOrder()).equals("[8]"));
		System.out.println(Arrays.toString(minhaArvore.order()).equals("[8]"));
		System.out.println(Arrays.toString(minhaArvore.postOrder()).equals("[8]"));
		minhaArvore.insert(12);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(14);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(15);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(4);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(2);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(1);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(13);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(3);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(6);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(7);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(10);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(9);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(5);
		System.out.println(!minhaArvore.isComplete());
		minhaArvore.insert(11);
		System.out.println(minhaArvore.isComplete());
		for (int k = 1; k <= 15; k++) {
			System.out.println(minhaArvore.search(k) == k);
		}
		System.out.println(Arrays.toString(minhaArvore.preOrder()).equals(Arrays.toString(new int[]{8,4,2,1,3,6,5,7,12,10,9,11,14,13,15})));
		System.out.println(Arrays.toString(minhaArvore.order()).equals(Arrays.toString(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})));
		System.out.println(Arrays.toString(minhaArvore.postOrder()).equals(Arrays.toString(new int[]{1,3,2,5,7,6,4,9,11,10,13,15,14,12,8})));
		System.out.println();
		
		System.out.println("Brincando com TabelaHash...");
		TabelaHash_IF minhaTabelaHash = new TabelaHash(8);
		System.out.println(minhaTabelaHash.print().equals("0: \n1: \n2: \n3: \n4: \n5: \n6: \n7: \n"));
		for (int key = 1; key < 25; key++) {
			minhaTabelaHash.insert(key);
			System.out.println(minhaTabelaHash.search(key) == key);
		}
		System.out.println(minhaTabelaHash.print().equals("0: 24, 16, 8\n1: 17, 9, 1\n2: 18, 10, 2\n3: 19, 11, 3\n4: 20, 12, 4\n5: 21, 13, 5\n6: 22, 14, 6\n7: 23, 15, 7\n"));
		int[] elementosARemover = new int[]{1,2,5,7,8,9,13,17,18,20,21,23};
		for (int i = 0; i < elementosARemover.length; i++) {
			minhaTabelaHash.remove(elementosARemover[i]);
		}
		System.out.println(minhaTabelaHash.print().equals("0: 24, 16\n1: \n2: 10\n3: 19, 11, 3\n4: 12, 4\n5: \n6: 22, 14, 6\n7: 15\n"));
		System.out.println();
				
		//OBS.: Espera-se que nenhum print mostre 'false' na tela!
		
	}
	

}