package Menus;

import javax.swing.JOptionPane;
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
                    CadastrarUsuario.cadastrar(listaUsuarios);
                }
                case CONSULTAR_POR_CPF -> {
                    for (Usuario u : listaUsuarios) {
                        System.out.println("Usuário: " + u.exibirUsuario());
                    }
                    String cpf = JOptionPane.showInputDialog("Insira o CPF: ");
                    if (cpf != null) {
                        String resultado = ConsultaPorCpf.Consultar(cpf, listaUsuarios);
                        if (resultado != null) {
                            JOptionPane.showMessageDialog(null, resultado, "Resultado da Consulta", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "CPF não encontrado.", "Resultado da Consulta", JOptionPane.WARNING_MESSAGE);
                        }

                    }
                }
                case EDITAR_CADASTRO -> {
                    EditarUsuario.Editar(listaUsuarios);
                }
                case EXCLUIR_USUÁRIO -> {
                    String cpf = JOptionPane.showInputDialog("Insira o CPF: ");
                    ExcluirUsuario.excluirPorCpf(cpf, listaUsuarios);
                    
                }
                case LISTAR_TODOS -> {
                    ListarUsuarios.Listar(listaUsuarios);
                }
                case VOLTAR -> JOptionPane.showMessageDialog(null, "Voltando ao menu princípal");
            }
            
        }while(opcao != MenuAlugueis.VOLTAR.getValorOp());
    }
}
