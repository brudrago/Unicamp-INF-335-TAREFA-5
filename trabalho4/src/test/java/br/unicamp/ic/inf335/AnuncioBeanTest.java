package br.unicamp.ic.inf335;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnuncioBeanTest {

    private ProdutoBean produto(double valor) {
        ProdutoBean p = new ProdutoBean();
        p.setValor(valor);
        return p;
    }

    @Test
    void getValor_semDesconto_retornaValorIntegral() {
        AnuncioBean an = new AnuncioBean();
        an.setProduto(produto(100.0));
        an.setDesconto(0.0);
        assertEquals(100.0, an.getValor(), 0.0001);
    }

    @Test
    void getValor_com50Porcento_aplicaDescontoCorreto() {
        AnuncioBean an = new AnuncioBean();
        an.setProduto(produto(200.0));
        an.setDesconto(0.5);
        assertEquals(100.0, an.getValor(), 0.0001);
    }

    @Test
    void getValor_com100Porcento_retornaZero() {
        AnuncioBean an = new AnuncioBean();
        an.setProduto(produto(99.9));
        an.setDesconto(1.0);
        assertEquals(0.0, an.getValor(), 0.0001);
    }

    @Test
    void getValor_descontoForaDaFaixa_deveSerTratado() {
        AnuncioBean an = new AnuncioBean();
        an.setProduto(produto(100.0));
        an.setDesconto(2.0); // valor inválido → esperado tratamento
        double v = an.getValor();
        assertTrue(v >= 0.0 && v <= 100.0, "Desconto inválido não pode gerar valor > preço ou negativo");
    }
}
