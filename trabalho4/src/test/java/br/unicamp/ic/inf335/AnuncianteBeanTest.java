package br.unicamp.ic.inf335;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AnuncianteBeanTest {

    private AnuncioBean anuncio(double precoProduto, double desconto) {
        ProdutoBean p = new ProdutoBean(); p.setValor(precoProduto);
        AnuncioBean a = new AnuncioBean();
        a.setProduto(p);
        a.setDesconto(desconto);
        return a;
    }

    @Test
    void valorMedioAnuncios_listaVazia_retornaZero() {
        AnuncianteBean an = new AnuncianteBean();
        an.setAnuncios(new ArrayList<>());
        assertEquals(0.0, an.valorMedioAnuncios(), 0.0001);
    }

    @Test
    void valorMedioAnuncios_calculaMediaComDescontos() {
        AnuncianteBean anunciante = new AnuncianteBean();
        ArrayList<AnuncioBean> lista = new ArrayList<>();
        lista.add(anuncio(100.0, 0.0));   // 100
        lista.add(anuncio(200.0, 0.5));   // 100
        anunciante.setAnuncios(lista);

        assertEquals(100.0, anunciante.valorMedioAnuncios(), 0.0001);
    }

    @Test
    void adicionarERemoverAnuncio_mantemConsistenciaDaLista() {
        AnuncianteBean anunciante = new AnuncianteBean();
        anunciante.setAnuncios(new ArrayList<>());

        AnuncioBean a1 = anuncio(150.0, 0.0);
        AnuncioBean a2 = anuncio(100.0, 0.5);

        anunciante.addAnuncio(a1);
        anunciante.addAnuncio(a2);

        assertEquals(2, anunciante.getAnuncios().size(),
                "Após adicionar 2 anúncios a lista deve ter 2 itens");

        // remove pelo índice (sua classe expõe removeAnuncio(int))
        anunciante.removeAnuncio(0);

        assertEquals(1, anunciante.getAnuncios().size(),
                "Após remover, a lista deve ter 1 item");
        assertSame(a2, anunciante.getAnuncios().get(0));
    }
}