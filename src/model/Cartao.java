package model;

public class Cartao {
    private String numeroCartao;
    private String tipo;
    private String validade;
    private double limiteCartao;
    private int cvv;
    public Conta contaAssociada;

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Conta getContaAssociada() {
        return contaAssociada;
    }

    public void setContaAssociada(Conta contaAssociada) {
        this.contaAssociada = contaAssociada;
    }
}
