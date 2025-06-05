import controller.BancoController;
import view.CriarContaView;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BancoController banco = new BancoController();
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
                    CriarContaView.interfaceCriarConta(banco);
                    break;
                case "2":

            }
        }while (!resp.equals("6"));
    }
}