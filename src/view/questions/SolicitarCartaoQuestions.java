package view.questions;

import controller.BancoController;
import model.Conta;

import java.util.Scanner;

public class SolicitarCartaoQuestions {

    public static void solicitarCartaoQuestions(BancoController banco, Conta conta) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o tipo de cartão que deseja solicitar: " +
                           "[1] Crédito         " +
                           "[2] Débito          ");
        String resp = input.nextLine();
        String tipoCartao;
        if (resp.equals("1")) {
            tipoCartao = "Crédito";
        }else{
            tipoCartao = "Débito";
        }
        System.out.println("Cartão gerado com sucesso!");
        banco.solicitarCartao(conta,banco,tipoCartao);
    }

}
