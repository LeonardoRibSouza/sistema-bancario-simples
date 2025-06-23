package controller;

import exception.ErroView;
import model.Cartao;
import model.Conta;
import save.ArquivarUtil;
import util.CartaoUtil;
import util.VerificadorUtil;
import view.menus.MenuInicialView;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BancoController{
    ArrayList<Conta> contas;
    ArquivarUtil save = new ArquivarUtil();

    public BancoController(ArrayList<Conta> contas) {
       this.contas = contas;
    }

    public void cadastrarConta(String nome,String senha,int idade,String cpf,String cep,String telefone,String email,BancoController banco) {

        while(true) {
            if (!VerificadorUtil.verificarIdade(idade)) {
                ErroView.menorDeIdadeErro();
                break;
            }

           if (!VerificadorUtil.verificarCpf(cpf)) {
                ErroView.caractereInvalidaErro("cpf");
                break;
           }

            if (!VerificadorUtil.verificarEmail(email)) {
                ErroView.caractereInvalidaErro("email");
                break;
            }

            if (!VerificadorUtil.verificarTelefone(telefone)) {
                ErroView.caractereInvalidaErro("telefone");
                break;
            }

            Conta novaConta = new Conta(nome,senha, idade,cpf,cep,telefone,email);
            contas = save.lerUsuarios();

            Conta contaAnterior;
            Long idAnterior = 0L;
            if(contas.size()>1) {
                contaAnterior = contas.get(contas.size()-1);
                idAnterior = contaAnterior.getId();
                novaConta.setId(idAnterior+1);
            }else if(contas.size()==1) {
                novaConta.setId(idAnterior+1);
            }else{
                novaConta.setId(1L);
            }


            contas.add(novaConta);
            save.salvarUsuarios(contas);
            logarConta(cpf,senha,banco);
            break;
        }
    }

    public void logarConta(String cpf,String senha,BancoController banco){
        contas = save.lerUsuarios();
        Conta contaAutenticada =null;
        for (Conta conta : contas) {
            if (conta.getCpf().equals(cpf) && conta.getSenha().equals(senha)) {
                contaAutenticada = conta;
                break;
            }
        }
        if (contaAutenticada == null){
            System.out.println("CPF ou senha inválidos!!!");
        }else {
            MenuInicialView.interfaceMenuInicialView(contaAutenticada,banco);
        }
    }

    public void transferirSaldo(String cpf,BigDecimal valor, Conta conta){
        contas = save.lerUsuarios();
        
        if (conta.getSaldo().compareTo(valor)>=0){

            for (Conta alvo : contas){

                if (alvo.getCpf().equals(cpf)) {
                    alvo.setSaldo(alvo.getSaldo().add(valor));
                    conta.setSaldo(conta.getSaldo().subtract(valor));
                    save.salvarUsuarios(contas);
                    break;
                }
            }
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void solicitarCartao(Conta conta,String tipoCartao) {
        contas = save.lerUsuarios();
        for(Conta alvo : contas){
            if(alvo.getCpf().equals(conta.getCpf())){
                String numeroCartao = CartaoUtil.gerarNumeroCartao();

                Cartao cartao = new Cartao();
                cartao.setNumeroCartao(numeroCartao);
                cartao.setContaAssociada(conta);
                cartao.setTipo(tipoCartao);
                cartao.setTitular(conta.getNome());
                cartao.setValidade(CartaoUtil.gerarDataDeValidade());
                cartao.setCvv(CartaoUtil.gerarCvv());

                alvo.setCartaoVinculado(cartao);
            }

        }
        save.salvarUsuarios(contas);
    }

    public Conta atualizarConta(Conta conta){
        contas = save.lerUsuarios();
        for(Conta alvo : contas){
            if (alvo.getId().equals(conta.getId())) {
                return alvo;
            }
        }
        return conta;
    }

}
