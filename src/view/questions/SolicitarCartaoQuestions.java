package view.questions;

import controller.BancoController;
import model.Conta;
import java.util.Scanner;

public class SolicitarCartaoQuestions {

    public static void solicitarCartaoQuestions(BancoController banco, Conta conta){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Digite o tipo de Cartao que deseja solicitar
                [1] Crédito
                [2] Débito
                """);
        String resp = input.nextLine();
        String tipoCartao;
        if (resp.equals("1")) {
            tipoCartao = "Crédito";
        }else{
            tipoCartao = "Débito";
        }
        banco.solicitarCartao(conta,banco,tipoCartao);
        System.out.println("Cartão solicitado com sucesso!");
    }

}
