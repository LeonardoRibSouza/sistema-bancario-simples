package exception;

public class ErroView {

    public static void menorDeIdadeErro() {
        System.out.println("!!!Proibido para menores de 18 anos!!!");
    }

    public static void caractereInvalidaErro(String caractere) {
        System.out.println(caractere+" Invalido(a) !!!, tente novamente!");
    }

}
