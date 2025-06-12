package view.questions;

import controller.BancoController;
import model.Conta;
import util.VerificadorUtil;

import java.math.BigDecimal;
import java.util.Scanner;

public class Tranferencia {

    public static void perguntar(Conta conta, BancoController banco) {
        Scanner input = new Scanner(System.in);

        System.out.println("digite o CPF da conta que deseja tranferir: ");
        String cpf = input.nextLine();
        if (VerificadorUtil.verificarCpf(cpf)==false) throw new RuntimeException("CPF invalido");

        try {
            System.out.println("digite o valor que deseja tranferir: ");
            BigDecimal valor = new BigDecimal(input.nextLine());
            banco.transferirSaldo(cpf,valor,conta);
        }catch (Exception e){
            System.out.println("Digite um valor valido");
        }
    }
}
