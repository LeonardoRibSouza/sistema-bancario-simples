package controller;

import exception.ErroView;
import model.Conta;
import save.ArquivarUtil;
import util.VerificadorUtil;
import view.menus.MenuInicialView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class BancoController{
    ArrayList<Conta> contas;
    ArquivarUtil save = new ArquivarUtil();

    public BancoController(ArrayList<Conta> contas) {
       this.contas = contas;
    }

    public void cadastrarConta(String nome,String senha,int idade,String cpf,String cep,String telefone,String email,BancoController banco) throws IOException {

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
            save.salvarUsuarios(contas);
            logarConta(cpf,senha,banco);
            break;
        }
    }

    public void logarConta(String cpf,String senha,BancoController banco) throws FileNotFoundException {
        contas = save.lerUsuarios();
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
                    alvo.setSaldo(alvo.getSaldo().add(valor));
                    conta.setSaldo(conta.getSaldo().subtract(valor));
                    break;
                }
            }
        }else{
            throw new RuntimeException("sem saldo suficiente");
        }
    }
}
