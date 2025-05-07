package Usuario;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ExcluirUsuario {
    public static void excluirPorCpf(String cpfBusca, ArrayList<Usuario> listaUsuario) {
        Usuario usuarioParaRemover = null;

        for (Usuario u : listaUsuario) {
            if (u.getCpf().equals(cpfBusca)) {
                usuarioParaRemover = u;
                break;
            }
        }

        if (usuarioParaRemover != null) {
            listaUsuario.remove(usuarioParaRemover);
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "CPF não encontrado. Nenhum usuário foi excluído.", "Exclusão", JOptionPane.WARNING_MESSAGE);
        }
    }
}
