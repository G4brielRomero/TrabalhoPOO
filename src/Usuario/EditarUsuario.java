package Usuario;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditarUsuario {
    public static void Editar(ArrayList<Usuario> listaUsuarios){
        String cpf = JOptionPane.showInputDialog("Informe o cpf");
        if(!ValidadorCPF.isCPF(cpf)){
            JOptionPane.showMessageDialog(null, "Cpf informado não é valido, retornando para o menu anterior.","Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for(Usuario u : listaUsuarios){
            if(u.getCpf().equals(cpf)){
               String nome = JOptionPane.showInputDialog("Informe o novo nome para edicao\n"); 
               u.setNome(nome);
               String contato = JOptionPane.showInputDialog("Informe o novo contato para edicao\n"); 
               u.setContato(contato);
            }
        }
    }
}
