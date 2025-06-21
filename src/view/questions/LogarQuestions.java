package view.questions;

import controller.BancoController;
import java.util.Scanner;

public class LogarQuestions {

    public static void interfaceLogin(BancoController banco) {
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("""
                ---------------------------
                [1] para sair.
                Digite sua infomações:
                Cpf:""");
            String cpf = input.nextLine();

            System.out.print("Senha: ");
            String senha = input.nextLine();

            banco.logarConta(cpf,senha,banco);
            System.out.println("Essa conta não existe!");
            if (cpf.equals("1") || senha.equals("1")) {
                break;
            }
        }while(true);
    }

}
