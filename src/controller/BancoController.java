package controller;

import model.Conta;
import util.ContaUtil;
import util.VerificadorUtil;
import view.ErroView;
import view.MenuInicialView;

import java.util.ArrayList;
import java.util.Random;

public class BancoController {
    ArrayList<Conta> contas = new ArrayList<>();

    public void cadastrarConta(String nome,String senha,int idade,String cpf,String cep,String telefone,String email) {
        while(true) {
            if (!(VerificadorUtil.verificarIdade(idade) == true)) {
                ErroView.menorDeIdadeView();
                break;
            }
            if (!(VerificadorUtil.verificarCpf(cpf) == true)) {
                ErroView.mensagemInvalidaView();
                break;
            }
            Conta novaConta = new Conta(nome,senha, idade,cpf,cep,telefone,email);
            contas.add(novaConta);
        }
    }
    public void exibirSaldo(){

    }

    public void logarConta(String cpf,String senha,BancoController banco){
        for(Conta conta : contas){
            if(conta.getCpf().equals(cpf) && conta.getSenha().equals(senha)){
                MenuInicialView.interfaceMenuInicialView(conta,banco);
            }
        }
    }



}
