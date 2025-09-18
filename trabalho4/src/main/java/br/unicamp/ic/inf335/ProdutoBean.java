package br.unicamp.ic.inf335;

public class ProdutoBean implements java.io.Serializable, Comparable<ProdutoBean> {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nome;
    private String descricao;
    private Double valor;
    private String estado;

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public static long getSerialversionuid() { return serialVersionUID; }

    public ProdutoBean() {
        codigo = "";
        nome = "";
        descricao = "";
        valor = 0.0;
        estado = "";
    }

    public ProdutoBean(String codigo, String nome, String descricao, Double valor, String estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estado = estado;
    }

    @Override
    public int compareTo(ProdutoBean p) {
        // FIX: usava '>' nas duas comparações e nunca retornava -1.
        // Também evita NPE tratando null como 0.0 (ou poderia lançar).
        double a = this.valor == null ? 0.0 : this.valor;
        double b = (p == null || p.getValor() == null) ? 0.0 : p.getValor();
        return Double.compare(a, b);
    }
}
