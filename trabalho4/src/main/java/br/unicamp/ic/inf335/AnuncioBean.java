package br.unicamp.ic.inf335;

import java.net.URL;
import java.util.ArrayList;

public class AnuncioBean implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    /** Produto anunciado */
    private ProdutoBean produto;
    /** Lista de URLs de fotos do anúncio */
    private ArrayList<URL> fotosUrl;
    /** Fração de desconto no intervalo [0.0, 1.0] */
    private Double desconto;

    public ProdutoBean getProduto() { return produto; }
    public void setProduto(ProdutoBean produto) { this.produto = produto; }

    public ArrayList<URL> getFotosUrl() { return fotosUrl; }
    public void setFotosUrl(ArrayList<URL> fotosUrl) { this.fotosUrl = fotosUrl; }

    public Double getDesconto() { return desconto; }
    public void setDesconto(Double desconto) { this.desconto = desconto; }

    public static long getSerialversionuid() { return serialVersionUID; }

    /** Construtor default */
    public AnuncioBean() {
        produto = new ProdutoBean();
        fotosUrl = new ArrayList<>();
        desconto = 0.0;
    }

    /** Construtor com parâmetros */
    public AnuncioBean(ProdutoBean produto, ArrayList<URL> fotosUrl, Double desconto) {
        this.produto = produto;
        this.fotosUrl = fotosUrl != null ? fotosUrl : new ArrayList<>();
        this.desconto = desconto;
    }

    /**
     * Calcula o valor do anúncio: valor do produto menos percentual de desconto.
     * Especificação: desconto ∈ [0.0, 1.0].
     */
    public Double getValor() {
        // FIX: fórmula anterior fazia valor - (valor / desconto), gerando infinito/negativo.
        if (produto == null || produto.getValor() == null) return 0.0;
        double v = produto.getValor();

        // Normaliza desconto para o intervalo [0,1] e trata null.
        double d = desconto == null ? 0.0 : desconto;
        if (d < 0.0) d = 0.0;
        if (d > 1.0) d = 1.0;

        return v * (1.0 - d);
    }
}
