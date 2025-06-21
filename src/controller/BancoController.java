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
            contas.add(novaConta);
            save.salvarUsuarios(contas);
            logarConta(cpf,senha,banco);
            break;
        }
    }

    public void logarConta(String cpf,String senha,BancoController banco){
        contas = save.lerUsuarios();
        for(Conta conta : contas){
            if(conta.getCpf().equals(cpf) && conta.getSenha().equals(senha)){
                MenuInicialView.interfaceMenuInicialView(conta,banco);
                break;
            }
        }
    }

    public void transferirSaldo(String cpf,BigDecimal valor, Conta conta){
        contas = save.lerUsuarios();
        
        if (conta.getSaldo().compareTo(valor)>=0){

            for (Conta alvo : contas){

                if (alvo.getCpf().equals(cpf)) {
                    alvo.setSaldo(alvo.getSaldo().add(valor));
                    conta.setSaldo(conta.getSaldo().subtract(valor));
                    break;
                }
            }
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    public void solicitarCartao(Conta conta,BancoController banco,String tipoCartao) {
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
                conta = alvo;
            }

        }
        save.salvarUsuarios(contas);
    }

}
