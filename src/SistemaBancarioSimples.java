import controller.BancoController;
import model.Conta;
import view.questions.CriarContaQuestions;
import view.questions.LogarQuestions;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SistemaBancarioSimples {
    public static void main(String[] args) {
        ArrayList<Conta> contas = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        BancoController banco = new BancoController(contas);
        String resp = "0";
        System.out.println("----------------Banco----------------");
        do {
            System.out.print("""
                    [1] Criar uma conta
                    [2] Entra na minha conta
                    [3] Sair
                    """);
            resp = input.nextLine();
            switch (resp) {
                case "1":
                    CriarContaQuestions.interfaceCriarConta(banco,input);
                    break;
                case "2":
                    LogarQuestions.interfaceLogin(banco,input);
                    break;
                case "3":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida!!!, tente novamente!");
            }
        }while (!resp.equals("3"));
    }
}