package view;

import controller.BancoController;
import model.Conta;

import java.util.Scanner;

public class MenuInicialView {
    public static void interfaceMenuInicialView(Conta conta, BancoController banco) {
        Scanner input = new Scanner(System.in);
        String resp = "0";

        do {
            System.out.printf("----------------Menu Inicial----------------");
            System.out.print("Saldo: "+conta.getSaldo());
            System.out.print("""
                    [1] Fazer Tranferencia
                    [2] Solicitar Cartão
                    [3] 
                    """);
            resp = input.nextLine();
            switch (resp) {
                case "1":
                    CriarContaView.interfaceCriarConta(banco);
                    break;
                case "2":
                    ExibirSaldoView.interfaceSaldo(banco);
                    break;
                case "5":
                    banco.();
                    break;
                default:
                    System.out.println("opacao incorreta");
            }
        }while (!resp.equals("6"));
    }
}
