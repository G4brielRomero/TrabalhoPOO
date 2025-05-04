package Transacao;
import java.util.ArrayList;

public class ListarTransacoes {
    public static void listar(ArrayList<Transacao> listTransacoes){
        for(Transacao t: listTransacoes){
            t.exibirTransacao();
        }
    }
}
