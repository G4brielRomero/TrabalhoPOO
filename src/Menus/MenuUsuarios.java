package Menus;

import javax.swing.JOptionPane;
import Usuario.CadastrarUsuarios;
import java.util.ArrayList;
import Usuario.*;

public enum MenuUsuarios{
    CADASTRAR_NOVO_USUÁRIO(1, "Cadastrar Novo Usuário"),
    CONSULTAR_POR_CPF(2, "Consultar Por CPF"),
    EDITAR_CADASTRO(3, "Editar Cadastro"),
    EXCLUIR_USUÁRIO(4, "Excluir Usuário"),
    LISTAR_TODOS(5, "Listar Todos os Usuários"),
    VOLTAR(6, "Voltar");
    
    private final int valorOp;
    private final String descricao;
    
    private MenuUsuarios(int valorOp, String descricao){
        this.valorOp = valorOp;
        this.descricao = descricao;
    }

    public int getValorOp() {
        return valorOp;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static MenuUsuarios Codigo(int codigo){
        for(MenuUsuarios opcao : values()){
            if(opcao.getValorOp() == codigo){
                return opcao;
            }
        }
        return null;
    }
    
    public static String getMenu(){
        String menu = "======== GERENCIAR USUÁRIOS ========\n";
        for(MenuUsuarios opcao : values()){
            menu = menu + opcao.getValorOp() + " - " + opcao.getDescricao() + "\n";
        }
        return menu;
    }
    
    public static void exibir(ArrayList<Usuario> usuarios){
        int opcao = -1;

        do {
            String input = JOptionPane.showInputDialog(getMenu());
            if (input == null){ 
                JOptionPane.showMessageDialog(null, "Voltando ao menu princípal");
                break;
            }
            //tratar com o professor
            if(!input.isEmpty() && input.chars().allMatch(Character::isDigit)) {
                opcao = Integer.parseInt(input);
            } else {
                JOptionPane.showMessageDialog(null, "Entrada Inválida!", "Menu Usuário", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            MenuUsuarios selecionado = Codigo(opcao);
            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Menu Usuário", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            switch (selecionado) {
                case CADASTRAR_NOVO_USUÁRIO -> {
                    CadastrarUsuarios.cadastrar(usuarios);
                }
                case CONSULTAR_POR_CPF -> {
                    System.out.println("A ser implementado");
                    // MenuFerramentas.exibir(usuarios);
                }
                case EDITAR_CADASTRO -> {
                    System.out.println("A ser implementado");
                    // MenuAlugueis.exibir(usuarios);
                }
                case EXCLUIR_USUÁRIO -> {
                    System.out.println("A ser implementado");
                }
                case LISTAR_TODOS -> {
                    System.out.println("A ser implementado");
                }
                case VOLTAR -> JOptionPane.showMessageDialog(null, "Voltando ao menu princípal");
            }
            
        }while(opcao != MenuAlugueis.VOLTAR.getValorOp());
    }
}
