package Menus;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import Usuario.*;
import Ferramenta.*;

public enum MenuFerramentas{
    CADASTRAR_NOVA_FERRAMENTA(1, "Cadastro de Nova Ferramenta"),
    BUSCAR_POR_NOME_CÓDIGO(2, "Buscar por Nome ou Código"),
    ALTERAR_PREÇO(3, "Alterar Preço"),
    ATUALIZAR_STATUS(4, "Atualizar Status"),
    LISTAR_DISPONÍVEIS(5, "Listar Ferramentas Disponíveis"),
    VOLTAR(6, "Voltar");
    
    private final int valorOp;
    private final String descricao;
    
    private MenuFerramentas(int valorOp, String descricao){
        this.valorOp = valorOp;
        this.descricao = descricao;
    }

    public int getValorOp() {
        return valorOp;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static MenuFerramentas Codigo(int codigo){
        for(MenuFerramentas opcao : values()){
            if(opcao.getValorOp() == codigo){
                return opcao;
            }
        }
        return null;
    }
    
    public static String getMenu(){
        String menu = "======== GERENCIAR FERRAMENTAS ========\n";
        for(MenuFerramentas opcao : values()){
            menu = menu + opcao.getValorOp() + " - " + opcao.getDescricao() + "\n";
        }
        return menu;
    }
    
    public static void exibir(ArrayList<Usuario> listaUsuarios){
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
                JOptionPane.showMessageDialog(null, "Entrada Inválida!", "Menu Ferramentas", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            MenuFerramentas selecionado = Codigo(opcao);
            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Menu Ferramentas", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            switch (selecionado) {
                case CADASTRAR_NOVA_FERRAMENTA -> {
                    System.out.println("A ser implementado");
                    CadastrarFerramenta.CadastrarNovaFerramenta(listaUsuarios);
                }
                case BUSCAR_POR_NOME_CÓDIGO -> {
                    System.out.println("A ser implementado");
                    // MenuFerramentas.exibir(usuarios);
                }
                case ALTERAR_PREÇO -> {
                    System.out.println("A ser implementado");
                    // MenuAlugueis.exibir(usuarios);
                }
                case ATUALIZAR_STATUS -> {
                    AlterarStatus.alteracaoStatus(listaUsuarios);
                }
                case LISTAR_DISPONÍVEIS -> {
                    System.out.println("A ser implementado");
                }
                case VOLTAR -> JOptionPane.showMessageDialog(null, "Voltando ao menu princípal");
            }
            
        }while(opcao != MenuAlugueis.VOLTAR.getValorOp());
    }
}
