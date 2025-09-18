package br.unicamp.ic.inf335;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoBeanTest {

    @Test
    void compareTo_retornanegativo_quandoEsteMenor() {
        ProdutoBean a = new ProdutoBean(); a.setValor(50.0);
        ProdutoBean b = new ProdutoBean(); b.setValor(100.0);
        assertTrue(a.compareTo(b) < 0, "Quando this.valor < outro.valor deve retornar negativo");
    }

    @Test
    void compareTo_retornaZero_quandoIguais() {
        ProdutoBean a = new ProdutoBean(); a.setValor(100.0);
        ProdutoBean b = new ProdutoBean(); b.setValor(100.0);
        assertEquals(0, a.compareTo(b), "Quando os valores são iguais deve retornar 0");
    }

    @Test
    void compareTo_retornaPositivo_quandoEsteMaior() {
        ProdutoBean a = new ProdutoBean(); a.setValor(200.0);
        ProdutoBean b = new ProdutoBean(); b.setValor(100.0);
        assertTrue(a.compareTo(b) > 0, "Quando this.valor > outro.valor deve retornar positivo");
    }

    @Test
    void compareTo_funcionaEmSortDaLista() {
        ProdutoBean p1 = new ProdutoBean(); p1.setValor(300.0);
        ProdutoBean p2 = new ProdutoBean(); p2.setValor(100.0);
        ProdutoBean p3 = new ProdutoBean(); p3.setValor(200.0);

        List<ProdutoBean> lista = new ArrayList<>();
        Collections.addAll(lista, p1, p2, p3);
        Collections.sort(lista);

        assertEquals(100.0, lista.get(0).getValor());
        assertEquals(200.0, lista.get(1).getValor());
        assertEquals(300.0, lista.get(2).getValor());
    }
}

