package Menus;

import javax.swing.JOptionPane;

public enum MenuAlugueis{
    REALIZAR_ALUGUEL(1, "Realizar Alguel"),
    REGISTRAR_DEVOLUÇÃO(2,"Realizar Devolução"),
    CONSULTAR_ALUGUEL_ATIVO(3,"Consultar Alguel Ativo"),
    CALCULAR_MULTA_POR_ATRASO(4,"Calcular Multa Por Atraso"),
    LISTAR_HISTÓRICO(5,"Listar Histórico"),
    VOLTAR(6,"Voltar");
            
    private final int valorOp;
    private final String descricao;

    private MenuAlugueis(int valorOp, String descricao) {
        this.valorOp = valorOp;
        this.descricao = descricao;
    }

    public int getValorOp() {
        return valorOp;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static MenuAlugueis Codigo(int codigo){
        for(MenuAlugueis opcao : values()){
            if(opcao.getValorOp() == codigo){
                return opcao;
            }
        }
        return null;
    }
    
    public static String getMenu(){
        String menu = "======== GERENCIAR ALUGUÉIS ========\n";
        for(MenuAlugueis opcao : values()){
            menu = menu + opcao.getValorOp() + " - " + opcao.getDescricao() + "\n";
        }
        return menu;
    }
    
    public static void exibir(){
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
                JOptionPane.showMessageDialog(null, "Entrada Inválida!", "Menu Aluguel", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            MenuAlugueis selecionado = Codigo(opcao);
            if (selecionado == null) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Menu Aluguel", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            switch (selecionado) {
            case REALIZAR_ALUGUEL -> {
                System.out.println("A ser implementado");
                // MenuUsuarios.exibir(usuarios);
            }
            case REGISTRAR_DEVOLUÇÃO -> {
                System.out.println("A ser implementado");
                // MenuFerramentas.exibir(usuarios);
            }
            case CONSULTAR_ALUGUEL_ATIVO -> {
                System.out.println("A ser implementado");
                // MenuAlugueis.exibir(usuarios);
            }
            case CALCULAR_MULTA_POR_ATRASO -> {
                System.out.println("A ser implementado");
            }
            case LISTAR_HISTÓRICO -> {
                System.out.println("A ser implementado");
            }
            case VOLTAR -> JOptionPane.showMessageDialog(null, "Voltando ao menu princípal");
            }
            
        }while(opcao != MenuAlugueis.VOLTAR.getValorOp());
    }
}
