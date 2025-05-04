package Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultaPorCpf {
    public static String Consultar(ArrayList<Usuario> listaUsuario){
        String cpfBusca;
        cpfBusca = JOptionPane.showInputDialog("Informe o cpf para busca.\n");
        if(!ValidadorCPF.isCPF(cpfBusca))
            return "Cpf informado não é valido.\n";
        String dados;
        for(Usuario u: listaUsuario){
            if(u.getCpf().equals(cpfBusca)){
                dados = u.exibirUsuario();
                return dados;
            }
        }
        return null;
    }
}
