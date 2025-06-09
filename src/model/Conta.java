package model;

import java.math.BigDecimal;

public class Conta {
    private String nome;
    private String senha;
    private int idade;
    private String cpf;
    private String cep;
    private String telefone;
    private String email;
    private Cartao numeroCartao;
    private BigDecimal saldo = new BigDecimal("0.0");
    private double limite;

    public Conta(String nome,String senha,int idade,String cpf,String cep,String telefone,String email) {
        setNome(nome);
        setSenha(senha);
        setIdade(idade);
        setCpf(cpf);
        setCep(cep);
        setTelefone(telefone);
        setEmail(email);
        setLimite(200.00);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Cartao numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
