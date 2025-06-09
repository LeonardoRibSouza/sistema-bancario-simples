package controller;

import model.Conta;
import util.VerificadorUtil;
import view.menus.MenuInicialView;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BancoController {
    ArrayList<Conta> contas = new ArrayList<>();

    public void cadastrarConta(String nome,String senha,int idade,String cpf,String cep,String telefone,String email,BancoController banco) {
        while(true) {
            if (!VerificadorUtil.verificarIdade(idade)) {
                ErroView.menorDeIdadeView();
                break;
            }
            if (!VerificadorUtil.verificarCpf(cpf)) {
                ErroView.mensagemInvalidaView();
                break;
            }
            Conta novaConta = new Conta(nome,senha, idade,cpf,cep,telefone,email);
            contas.add(novaConta);
            logarConta(cpf,senha,banco);
            break;
        }
    }

    public void logarConta(String cpf,String senha,BancoController banco){
        for(Conta conta : contas){
            if(conta.getCpf().equals(cpf) && conta.getSenha().equals(senha)){
                MenuInicialView.interfaceMenuInicialView(conta,banco);
                break;
            }
        }
    }

    public void transferirSaldo(String cpf,BigDecimal valor, Conta conta){
        if (conta.getSaldo().compareTo(valor)>=0){
            for (Conta alvo : contas){
                if (alvo.getCpf().equals(cpf)) {
                    alvo.setSaldo(valor);
                    conta.getSaldo().subtract(valor);
                }
            }
        }else{
            throw new RuntimeException("sem saldo suficiente");
        }
    }
}
