package Usuario;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class CadastrarUsuarios {
    public static void cadastrar(ArrayList<Usuario> usuarios){
        String nome, cpf, contato;
        
        while(true){
            nome = JOptionPane.showInputDialog("Informe o Nome: ");
            if(nome == null || nome.isBlank()){
                JOptionPane.showMessageDialog(null, "Entrada Inválida!", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            cpf = JOptionPane.showInputDialog("Insira o CPF: ");
            if(cpf == null || cpf.isBlank() || !ValidadorCPF.isCPF(cpf)){
                JOptionPane.showMessageDialog(null, "Entrada Inválida", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            String resultadoConsulta = ConsultaPorCpf.Consultar(usuarios, cpf);
            if(resultadoConsulta == null){
                JOptionPane.showMessageDialog(null, "CPF já Existente", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            contato = JOptionPane.showInputDialog("Informe o COntato: ");
            if(contato == null || contato.isBlank()){
                JOptionPane.showMessageDialog(null, "Entrada Inválida", "Cadastro de Usuários", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            
            Usuario novoUsuario = new Usuario(nome, cpf, contato);
            usuarios.add(novoUsuario);
            
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso", "Cadastro de Usuários", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}