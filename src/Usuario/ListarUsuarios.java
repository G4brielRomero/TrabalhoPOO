package Usuario;
import java.util.ArrayList;

public class ListarUsuarios {
    public static void Listar(ArrayList<Usuario> listaUsuario){
        for(Usuario u: listaUsuario){
            System.out.println(u.exibirUsuario());
        }
    }
}
