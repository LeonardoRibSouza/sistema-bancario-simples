import controller.BancoController;
import model.Conta;
import view.menus.LoginView;
import view.questions.CriarContaQuestions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Conta> contas = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        BancoController banco = new BancoController(contas);
        String resp = "0";
        System.out.println("----------------Banco----------------");
        do {
            System.out.print("""
                    [1] Criar uma conta
                    [2] Entra na minha conta
                    """);
            resp = input.nextLine();
            switch (resp) {
                case "1":
                    CriarContaQuestions.interfaceCriarConta(banco);
                    break;
                case "2":
                    LoginView.loginView(banco);
                    break;
                default:
                    System.out.println("Opção Invalida!!!, tente novamente!");
            }
        }while (!resp.equals("6"));
    }
}