package br.edu.uepb.eda.atividade01;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test0Busca {

    private Busca busca;
    private int[] testArray;

    @Before
    public void setUp() {
        busca = new Busca();
        // Substitua o tamanho e os valores do array de teste conforme necessário.
        testArray = busca.geraVetorNumericoOrdenado(10);
    }

    @Test
    public void testBuscaLinearIterativa() {
        assertTrue(busca.buscaLinear_iterativa(testArray, 5));
        assertFalse(busca.buscaLinear_iterativa(testArray, 11));
    }

    @Test
    public void testBuscaLinearRecursiva() {
        assertTrue(busca.buscaLinear_recursiva(testArray, 5));
        assertFalse(busca.buscaLinear_recursiva(testArray, 11));
    }

    @Test
    public void testBuscaLinearIterativaDuasPontas() {
        assertTrue(busca.buscaLinear_iterativa_duasPontas(testArray, 5));
        assertFalse(busca.buscaLinear_iterativa_duasPontas(testArray, 11));
    }

    @Test
    public void testBuscaBinariaIterativa() {
        assertTrue(busca.buscaBinaria_iterativa(testArray, 5));
        assertFalse(busca.buscaBinaria_iterativa(testArray, 11));
    }

    @Test
    public void testBuscaBinariaRecursiva() {
        assertTrue(busca.buscaBinaria_recursiva(testArray, 5));
        assertFalse(busca.buscaBinaria_recursiva(testArray, 11));
    }
}
