package Ferramenta;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import Usuario.*;

public class CadastrarFerramenta {

    public static void CadastrarNovaFerramenta(ArrayList<Usuario> listaUsuarios) {
        String cpf = JOptionPane.showInputDialog("Informe o CPF do usuário:");
        
        if (!ValidadorCPF.isCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Retornando ao menu anterior.");
            return;
        }

        Usuario usuario = null;
        for (Usuario u : listaUsuarios) {
            if (u.getCpf().equals(cpf)) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
            return;
        }

        String nome = JOptionPane.showInputDialog("Informe o nome da ferramenta:");
        String descricao = JOptionPane.showInputDialog("Informe a descrição:");
        String categoria = JOptionPane.showInputDialog("Informe a categoria (elétrica, manual, jardim):");

        double precoMinimo = BuscarValor.getPrecoMinino(categoria);
        if (precoMinimo == -1) {
            JOptionPane.showMessageDialog(null, "Categoria inválida!");
            return;
        }

        String precoStr;
        double precoPorDia = 0;

        while (true) {
            precoStr = JOptionPane.showInputDialog("Informe o preço por dia (mínimo R$ " + precoMinimo + "):");

            if (precoStr == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                return; // Sai do método
            }

            // Substitui vírgula por ponto para aceitar formato brasileiro
            precoStr = precoStr.replace(',', '.');

            if (!precoStr.matches("[0-9]+(\\.[0-9]+)?")) {
                JOptionPane.showMessageDialog(null, "Preço inválido! Use apenas números. Ex: 10.50 ou 10,50");
                continue; // Volta para pedir novamente
            }

            precoPorDia = Double.parseDouble(precoStr);
            if (precoPorDia < precoMinimo) {
                JOptionPane.showMessageDialog(null, "Preço abaixo do mínimo permitido para esta categoria.");
                continue;
            }

            break; // Valor válido, sai do loop
        }


        String status = "disponível";

        Ferramenta novaFerramenta = new Ferramenta(nome, descricao, precoPorDia, categoria, status, cpf);
        boolean adicionada = usuario.adicionarFerramenta(novaFerramenta);

        if (adicionada) {
            JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a ferramenta (limite de ferramentas ou nome repetido).");
        }
    }
}
