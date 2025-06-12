package view.questions;

import controller.BancoController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LogarQuestions {

    public static void login(BancoController banco) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("""
                ---------------------------
                Digite sua infomações:
                Cpf:""");
        String cpf = input.nextLine();
        System.out.print("Senha: ");
        String senha = input.nextLine();

        banco.logarConta(cpf,senha,banco);
    }

}
