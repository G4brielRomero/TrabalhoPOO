package Ferramenta;

import javax.swing.JOptionPane;
import Usuario.*;
import java.util.ArrayList;

public class AlterarStatus {
    public static void alteracaoStatus(ArrayList<Usuario> usuarios) {
        String nomeFerramenta;
        while (true) {
            nomeFerramenta = JOptionPane.showInputDialog("Digite o nome da ferramenta:");
            if (nomeFerramenta == null) {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação?", "Cancelar?", JOptionPane.YES_NO_OPTION);
                if (sair == JOptionPane.YES_OPTION) return;
                else continue;
            }
            nomeFerramenta = nomeFerramenta.trim();
            if (!nomeFerramenta.isEmpty()) break;
            JOptionPane.showMessageDialog(null, "O nome da ferramenta não pode estar vazio.");
        }

        String cpfDono;
        while (true) {
            cpfDono = JOptionPane.showInputDialog("Digite o CPF do dono da ferramenta:");
            if (cpfDono == null) {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação?", "Cancelar?", JOptionPane.YES_NO_OPTION);
                if (sair == JOptionPane.YES_OPTION) return;
                else continue;
            }
            cpfDono = cpfDono.trim();
            if (!cpfDono.isEmpty()) break;
            JOptionPane.showMessageDialog(null, "O CPF não pode estar vazio.");
        }

        String novoStatus;
        while (true) {
            novoStatus = JOptionPane.showInputDialog("Digite o novo status da ferramenta:\n(Disponível, Alugada, Indisponível)");
            if (novoStatus == null) {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação?", "Cancelar?", JOptionPane.YES_NO_OPTION);
                if (sair == JOptionPane.YES_OPTION) return;
                else continue;
            }

            novoStatus = novoStatus.trim();
            if (novoStatus.equalsIgnoreCase("Disponível") ||
                novoStatus.equalsIgnoreCase("Alugada") ||
                novoStatus.equalsIgnoreCase("Indisponível")) {
                break;
            }
            JOptionPane.showMessageDialog(null, "Status inválido. Digite apenas: Disponível, Alugada ou Indisponível.");
        }

        // Agora, buscar o usuário e alterar status
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpfDono)) {
                for (Ferramenta f : usuario.getListaDeFerramentas()) {
                    if (f.getNome().equalsIgnoreCase(nomeFerramenta)) {
                        String detalhes = f.exibirFerramenta();
                        int confirmar = JOptionPane.showConfirmDialog(null,
                            "Ferramenta encontrada:\n" + detalhes +
                            "\nDeseja alterar o status para '" + novoStatus + "'?",
                            "Confirmar Alteração",
                            JOptionPane.YES_NO_OPTION);

                        if (confirmar == JOptionPane.YES_OPTION) {
                            f.setStatus(novoStatus);
                            JOptionPane.showMessageDialog(null, "Status alterado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Alteração cancelada.");
                        }
                        return;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Nenhuma ferramenta encontrada com esse nome e CPF.");
    }
}
