package view.questions;

import model.Conta;
import save.ArquivarUtil;

import java.util.ArrayList;

public class MostrarDadosDoCartaoQuestions {

    public  static void exibirDados(Conta conta){
        ArquivarUtil save = new ArquivarUtil();
        ArrayList<Conta> contas;
        contas = save.lerUsuarios();

        for(Conta alvo : contas){
            if(alvo.getCpf().equals(conta.getCpf())){
                if(conta.getCartaoVinculado() == null){
                    System.out.println("Voçê ainda não solicitou um cartão");
                }else {
                    String exibicaoDosDados = String.format("""
                             Titular: %s
                            Numero: %s               Validade: %s
                            CVV: %s                  Limite: R$ %.2f
                            Tipo: %s
                            """,
                            conta.getCartaoVinculado().getTitular(),
                            conta.getCartaoVinculado().getNumeroCartao(),
                            conta.getCartaoVinculado().getValidade(),
                            conta.getCartaoVinculado().getCvv(),
                            conta.getCartaoVinculado().getLimiteCartao(),
                            conta.getCartaoVinculado().getTipo()
                    );
                    System.out.println(exibicaoDosDados);
                }
            }
        }
    }

}
