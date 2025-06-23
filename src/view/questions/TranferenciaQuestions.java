package view.questions;

import controller.BancoController;
import model.Conta;
import util.VerificadorUtil;

import java.math.BigDecimal;
import java.util.Scanner;

public class TranferenciaQuestions {

    public static void perguntar(Conta conta, BancoController banco,Scanner input) {
        input.nextLine();

        do{
            System.out.println("digite o CPF da conta que deseja tranferir: (digite 1 para sair!)");
            String cpf = input.nextLine();
            if (cpf.equals("1")) {
                break;
            }
            if (VerificadorUtil.verificarCpf(cpf) == false) {
                System.out.println("CPF invalido");
                break;
            }

            try {
                System.out.println("digite o valor que deseja tranferir: (digite 1 para sair!)");
                BigDecimal valor = new BigDecimal(input.nextLine());
                if (valor.equals("1")) {
                    break;
                }
                banco.transferirSaldo(cpf, valor, conta);
            } catch (Exception e) {
                System.out.println("Digite um valor valido");
            }
        }while (true);
    }
}
