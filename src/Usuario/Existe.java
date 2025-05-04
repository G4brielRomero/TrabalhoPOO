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
public class Existe {
    public static boolean isUsuarioExiste(ArrayList<Usuario> listaUsuarios, String cpf){
        for(Usuario usuario : listaUsuarios){
            if(usuario.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }
}
