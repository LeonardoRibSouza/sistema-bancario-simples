package util;

import java.util.Random;

public class CartaoUtil {

    public String gerarNumeroCartao(){
        int[] numeroCartao = new int[16];
        Random random = new Random();

        String bin= "4539";
        for (int i = 0;i < bin.length();i++){
            numeroCartao[i] = Character.getNumericValue(bin.charAt(i));
        }

        for(int i = 4;i < numeroCartao.length -1;i++) {
            numeroCartao[i] = random.nextInt(10);
        }
        int par = 0;
        int naoMultilplicados = 0;
        for (int i = numeroCartao.length -2;i >= 0;i--){
            if ((numeroCartao.length - 2- i)%2==0){
                int multiplicadoresPares = numeroCartao[i] * 2;
                if (multiplicadoresPares > 9){
                    multiplicadoresPares -= 9;
                }
                par += multiplicadoresPares;
            }else {
                naoMultilplicados += numeroCartao[i];
            }
        }
        int total = naoMultilplicados + par;
        int multiplo = total;
        while(!(multiplo % 10 == 0)){
            multiplo++;
        }
        int digitoFinal = multiplo - total;
        numeroCartao[15] = digitoFinal;
        String numeroCartaoPronto = "";
        for (int i = 0;i < numeroCartao.length;i++){
            numeroCartaoPronto += numeroCartao[i];
        }
        return numeroCartaoPronto;
    }

}
