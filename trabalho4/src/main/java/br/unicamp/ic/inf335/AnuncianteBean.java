package br.unicamp.ic.inf335;

import java.util.ArrayList;

public class AnuncianteBean {
    /** Nome do anunciante */
    private String nome;
    /** CPF do anunciante */
    private String CPF;
    /** Lista de anúncios do anunciante */
    private ArrayList<AnuncioBean> anuncios;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCPF() { return CPF; }
    public void setCPF(String cPF) { CPF = cPF; }

    public ArrayList<AnuncioBean> getAnuncios() { return anuncios; }
    public void setAnuncios(ArrayList<AnuncioBean> anuncios) { this.anuncios = anuncios; }

    /** Construtor default */
    public AnuncianteBean() {
        nome = "";
        CPF = "";
        anuncios = new ArrayList<>();
    }

    /** Construtor com parâmetros */
    public AnuncianteBean(String nome, String cPF, ArrayList<AnuncioBean> anuncios) {
        this.nome = nome;
        CPF = cPF;
        this.anuncios = (anuncios != null) ? anuncios : new ArrayList<>();
    }

    /** Inclui novo anúncio na lista */
    public void addAnuncio(AnuncioBean nAnuncio) {
        // FIX: garante lista não-nula
        if (anuncios == null) anuncios = new ArrayList<>();
        anuncios.add(nAnuncio);
    }

    /**
     * Remove anúncio por índice (forma original).
     * Mantida por compatibilidade, mas agora com validação.
     */
    public void removeAnuncio(int i) {
        // FIX: valida índice e lista para evitar IndexOutOfBounds/NPE
        if (anuncios != null && i >= 0 && i < anuncios.size()) {
            anuncios.remove(i);
        }
    }

    /** Sobrecarga: remove anúncio por objeto (uso mais natural nos testes) */
    public void removeAnuncio(AnuncioBean anuncio) {
        // FIX: oferece remoção por objeto
        if (anuncios != null) anuncios.remove(anuncio);
    }

    /**
     * Calcula o valor médio dos anúncios do anunciante.
     * Retorna 0.0 para lista vazia ou nula (evita divisão por zero).
     */
    public Double valorMedioAnuncios() {
        // FIX: tratava lista vazia com divisão por zero -> NaN
        if (anuncios == null || anuncios.isEmpty()) return 0.0;

        double soma = 0.0;
        for (AnuncioBean an : anuncios) {
            if (an != null) soma += an.getValor();
        }
        return soma / anuncios.size();
    }
}
