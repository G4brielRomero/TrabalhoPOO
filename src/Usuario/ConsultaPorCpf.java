/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;
import java.util.ArrayList;

/**
 *
 * @author muril
 */
public class ConsultaPorCpf {
    public static String Consultar(ArrayList<Usuario> listaUsuario, String cpfBusca){
        String dados;
        for(Usuario u: listaUsuario){
            if(u.getCpf().equals(cpfBusca)){
                dados = u.exibirUsuario();
                return dados;
            }
        }
        return null;
    }
}
