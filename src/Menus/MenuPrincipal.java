package menus;

import Usuario.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import static menus.MenuPrincipal.values;
import Menus.MenuAlugueis;
import Menus.MenuUsuarios;
import Menus.MenuFerramentas;

public enum MenuPrincipal {
    GERENCIAR_USUARIOS(1, "Gerenciar Usuários"),
    GERENCIAR_FERRAMENTAS(2, "Gerenciar Ferramentas"),
    GERENCIAR_ALUGUEIS(3, "Gerenciar Aluguéis"),
    RELATORIOS(4, "Relatórios"),
    SAIR(5, "Sair");

    private final int codigo;
    private final String descricao;

    private MenuPrincipal(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static MenuPrincipal Codigo(int codigo) {
        for (MenuPrincipal opcao : values()) {
            if (opcao.getCodigo() == codigo) {
                return opcao;
            }
        }
        return null;
    }

    public static String getMenu() {
        String menu = "======== TOOLSHARE ========\n";
        for(MenuPrincipal opcao : values()){
            menu = menu + opcao.getCodigo() + " - " + opcao.getDescricao() + "\n";
        }
        return menu;
    }

    public static void exibir(ArrayList<Usuario> usuarios) {
        int opcao = -1;

        do {
            String input = JOptionPane.showInputDialog(getMenu());
            if (input == null){ 
                JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                return; // Cancelado
            }
            //tratar com o professor
            if(!input.isEmpty() && input.chars().allMatch(Character::isDigit)) {
                opcao = Integer.parseInt(input);
            } else {
                JOptionPane.showMessageDialog(null, "Entrada Inválida!", "Menu Principal", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            MenuPrincipal selecionado = Codigo(opcao);
            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Menu Principal", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            switch (selecionado) {
            case GERENCIAR_USUARIOS -> {
                MenuUsuarios.exibir(usuarios);
            }
            case GERENCIAR_FERRAMENTAS -> {
                MenuFerramentas.exibir(usuarios);
            }
            case GERENCIAR_ALUGUEIS -> {
                MenuAlugueis.exibir();
            }
            case RELATORIOS -> JOptionPane.showMessageDialog(null, "Relatórios ainda não implementados.");
            case SAIR -> JOptionPane.showMessageDialog(null, "Saindo do sistema...");
            }

        } while (opcao != MenuPrincipal.SAIR.getCodigo());
    }
}
