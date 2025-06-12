package view.menus;

import controller.BancoController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {
    public static void loginView(BancoController banco) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("""
                Digite seu CPF:
                """);
        String cpf = input.nextLine();
        System.out.print("""
                Digite sua Senha:
        """);
        String senha = input.nextLine();
        banco.logarConta(cpf,senha,banco);
    }
}
