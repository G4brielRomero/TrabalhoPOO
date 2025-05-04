package trabalhopoo;
import java.util.ArrayList;
import Usuario.*;
import menus.MenuPrincipal;
import javax.swing.JOptionPane;
/**
 *
 * @author muril
 */
public class TrabalhoPOO {
    
    public static void main(String[] args) {
        ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();

        // Cadastro de 3 usuários com dados fixos
        Usuario usuario1 = new Usuario("Ana Souza", "ana@email.com", "12345678900");
        Usuario usuario2 = new Usuario("Carlos Lima", "carlos@gmail.com", "98765432100");
        Usuario usuario3 = new Usuario("Mariana Silva", "mariana@outlook.com", "45678912300");

        listaDeUsuarios.add(usuario1);
        listaDeUsuarios.add(usuario2);
        listaDeUsuarios.add(usuario3);

        // Consulta por CPF fixo
        String cpfBusca = "98765432100"; // CPF do Carlos Lima

        String resultado = ConsultaPorCpf.Consultar(listaDeUsuarios, cpfBusca);
        System.out.println("Resultado da consulta:\n" + resultado);
        MenuPrincipal.exibir(listaDeUsuarios);
    }
}
