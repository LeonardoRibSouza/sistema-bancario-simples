package view.questions;

import controller.BancoController;
import exception.ErroView;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CriarContaQuestions {
   public static void interfaceCriarConta(BancoController banco){
       Scanner input = new Scanner(System.in);
       String nome = "";
       String senha = "";
       String cpf = "";
       String cep = "";
       String telefone = "";
       String email = "";

       int idade = 0;
       do {
           System.out.println("---------------Criar-Conta------------");
           try{
                System.out.println("Nome completo: ");
                nome = input.nextLine();

                System.out.println("Senha: ");
                senha = input.nextLine();

                System.out.println("Idade: ");
                idade = Integer.parseInt(input.nextLine());

                System.out.println("CPF: ");
                cpf = input.nextLine();


                System.out.println("CEP: ");
                cep = input.nextLine();


                System.out.println("Telefone: ");
                telefone = input.nextLine();


                System.out.println("Email: ");
                email = input.nextLine();

               if(nome.isBlank() || cpf.isBlank() || cep.isBlank() || telefone.isBlank() || email.isBlank()){
                   System.out.println("Todos os campos devem ser preenchidos!");
                   continue;
               }
               break;
           } catch (NumberFormatException | InputMismatchException e) {
               ErroView.caractereInvalidaErro("Caractere");
           }
       }while (true);
       banco.cadastrarConta(nome,senha,idade,cpf,cep,telefone,email,banco);
   }
}
