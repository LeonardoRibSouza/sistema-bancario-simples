package util;

public class VerificadorUtil {
    public static boolean verificarCpf(String cpf) {

        if (cpf.length() == 11 && cpf.matches("\\d+")) {
            int digito = 0;
            int multiplicador = 10;
            int total = 0;
            for (int i = 0; i < cpf.length() - 2; i++) {
                digito = cpf.charAt(i) - '0';
                total += digito * multiplicador--;
            }
            int resto = total % 11;
            int verificadorUm;
            if (resto < 2) {
                verificadorUm = 0;
            } else {
                verificadorUm = 11 - resto;
            }

            total = 0;
            multiplicador = 11;

            for (int i = 0; i < cpf.length()-2; i++) {
                digito = cpf.charAt(i) - '0';
                total += digito * multiplicador--;
            }
            total += verificadorUm * 2;
            resto = total % 11;
            int verificadorDois;
            if (resto < 2) {
                verificadorDois = 0;
            } else {
                verificadorDois = 11 - resto;
            }

            if (verificadorUm == cpf.charAt(9) - '0' && verificadorDois == cpf.charAt(10) - '0') {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static  boolean verificarIdade(int idade){
        if(idade<18){
            return true;
        }else {
            return false;
        }
    }

}