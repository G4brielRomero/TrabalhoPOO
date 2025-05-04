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
public class ListarUsuarios {
    public static void Listar(ArrayList<Usuario> listaUsuario){
        for(Usuario u: listaUsuario){
            u.exibirUsuario();
        }
    }
}
