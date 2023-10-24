/*
Disciplina: Laboratório de Estrutura de Dados
Período e Turno: 2023.2, Manhã
Docente: Janderson Jason Barbosa Aguiar
Equipe: Eros Franklin Soares Félix, José Guilherme Morato Bizerra de Lima e Kaio Vinícius Cordeiro Batista 
*/

package atividade01;

public class BrincandoComBusca {

	public static void main(String[] args) {
		busca_IF b = new Busca();
		int i, repeticoes = 50, n = 10;
		final int numeroParaBuscar = -1;
		final int[] vetor = b.geraVetorNumericoOrdenado(n);
		long antes, depois, soma_tempos, media_tempos;

		System.out.printf("\nn = %d, k = %d\n", n, numeroParaBuscar);

		// busca linear
		soma_tempos = 0;
		for (i = 1; i <= repeticoes; i++) {
			antes = System.nanoTime();
			b.buscaLinear_iterativa(vetor, numeroParaBuscar);
			depois = System.nanoTime();
			soma_tempos += (depois - antes);
		}
		media_tempos = soma_tempos / repeticoes;
		System.out.println("buscaLinear_iterativa:\t" + (media_tempos));

		// busca linear de duas pontas
		soma_tempos = 0;
		for (i = 1; i <= repeticoes; i++) {
			antes = System.nanoTime();
			b.buscaLinear_iterativa_duasPontas(vetor, numeroParaBuscar);
			depois = System.nanoTime();
			soma_tempos += (depois - antes);
		}
		media_tempos = soma_tempos / repeticoes;
		System.out.println("buscaLinear_iterativa_duasPontas: " + (media_tempos));

		// busca binária
		soma_tempos = 0;
		for (i = 1; i <= repeticoes; i++) {
			antes = System.nanoTime();
			b.buscaBinaria_iterativa(vetor, repeticoes);
			depois = System.nanoTime();
			soma_tempos += (depois - antes);
		}
		media_tempos = soma_tempos / repeticoes;
		System.out.println("buscaBinaria_iterativa:\t" + (media_tempos));

		// busca binária recursiva
		soma_tempos = 0;
		for (i = 1; i <= repeticoes; i++) {
			antes = System.nanoTime();
			b.buscaBinaria_recursiva(vetor, numeroParaBuscar);
			depois = System.nanoTime();
			soma_tempos += (depois - antes);
		}
		media_tempos = soma_tempos / repeticoes;
		System.out.println("buscaBinaria_recursiva:\t" + (media_tempos));

		// busca linear recursiva
		soma_tempos = 0;
		for (i = 1; i <= repeticoes; i++) {
			antes = System.nanoTime();
			b.buscaLinear_recursiva(vetor, numeroParaBuscar);
			depois = System.nanoTime();
			soma_tempos += (depois - antes);
		}
		media_tempos = soma_tempos / repeticoes;
		System.out.println("buscaLinear_recursiva:\t" + (media_tempos));

	}

}
