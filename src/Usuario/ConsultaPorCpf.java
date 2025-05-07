package Usuario;

import java.util.ArrayList;

public class ConsultaPorCpf {
    public static String Consultar(String cpfBusca, ArrayList<Usuario> listaUsuario) {
        String dadosEncontrados = "";

        for (Usuario u : listaUsuario) {
            if (u.getCpf().equals(cpfBusca)) {
                dadosEncontrados += u.exibirUsuario() + "\n";
            }
        }

        if (!dadosEncontrados.isEmpty()) {
            return dadosEncontrados;
        } else {
            return null;
        }
    }
}
