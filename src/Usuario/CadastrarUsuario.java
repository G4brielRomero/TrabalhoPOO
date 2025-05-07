package Usuario;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CadastrarUsuario {
    public static void cadastrar(ArrayList<Usuario> usuarios) {
        String nome, cpf, contato;

        while (true) {
            nome = JOptionPane.showInputDialog("Informe o Nome: ");
            if (nome == null) 
                return; // Cancelado → volta ao menu
            if (nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Nome não pode estar em branco!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            cpf = JOptionPane.showInputDialog("Insira o CPF: ");
            if (cpf == null) 
                return; // Cancelado → volta ao menu
            if (cpf.isBlank() || !ValidadorCPF.isCPF(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inválido!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String resultadoConsulta = ConsultaPorCpf.Consultar(cpf, usuarios);
            if (resultadoConsulta != null) {
                JOptionPane.showMessageDialog(null, "CPF já existente", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            contato = JOptionPane.showInputDialog("Informe o Contato: ");
            if (contato == null) 
                return; // Cancelado → volta ao menu
            if (contato.isBlank()) {
                JOptionPane.showMessageDialog(null, "Contato não pode estar em branco!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            Usuario novoUsuario = new Usuario(nome, contato, cpf);
            usuarios.add(novoUsuario);

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Cadastro de Usuários", JOptionPane.INFORMATION_MESSAGE);
            int continuar = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro usuário?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (continuar != JOptionPane.YES_OPTION) {
                break;
            }
        }
    }
}
