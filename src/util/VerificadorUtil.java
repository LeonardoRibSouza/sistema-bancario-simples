package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorUtil {
    public static boolean verificarCpf(String cpf) {

        if (cpf == null) {
            System.out.println("cpf nulo");
        }else if (cpf.length() != 11) {
            System.out.println("deve conter 11 digitos");
        }

        for (int i = 0; i < cpf.length(); i++) {
            if (Character.isDigit(cpf.charAt(i))) {
                continue;
            } else {
                throw new IllegalArgumentException("caractere invalido");
            }
        }

        int peso = 10;
        int total = 0;
        for (int i = 0; i < cpf.length() - 2; i++) {
            int digito = cpf.charAt(i) - '0';
            total += digito * peso;
            peso--;
        }
        int digito1;
        if (total % 11 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - (total % 11);
        }

        peso = 11;
        total = 0;
        for (int i = 0; i < cpf.length() - 2; i++) {
            int digito = cpf.charAt(i) - '0';
            total += digito * peso;
            peso--;
        }
        total += digito1 * 2;

        int digito2;
        if (total % 11 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - (total % 11);
        }

        if (cpf.charAt(cpf.length() - 2) - '0' == digito1 && cpf.charAt(cpf.length() - 1) - '0' == digito2) {
            return true;
        } else {
            return false;
        }
    }

    public static  boolean verificarIdade(int idade){
        if(idade<18){
            return false;
        }else {
            return true;
        }
    }

    public static  boolean verificarEmail(String email){
        Pattern p = Pattern.compile("^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static  boolean verificarTelefone(String telefone){
        Pattern p = Pattern.compile("^\\d{2}9\\d{8}$");
        Matcher m = p.matcher(telefone);
        return m.find();
    }

}