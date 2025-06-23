package view.questions;

import controller.BancoController;
import java.util.Scanner;

public class LogarQuestions {

    public static void interfaceLogin(BancoController banco,Scanner input) {
        input.nextLine();
        do{
            System.out.println("""
                ---------------------------
                [1] para sair.
                Digite sua infomações:
                Cpf: (digite 1 para sair!)""");
            String cpf = input.nextLine();
            if(cpf.equals("1")){break;}

            System.out.print("Senha: (digite 1 para sair!)");
            String senha = input.nextLine();
            if(senha.equals("1")){break;}

            banco.logarConta(cpf,senha,banco);
        }while(true);
    }

}
