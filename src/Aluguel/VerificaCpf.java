package Aluguel;
import Usuario.Usuario;

public class VerificaCpf {

    public boolean verificaCpfAlugar(Usuario usuarioLocador, Usuario usuarioLocatario) {
        return !usuarioLocador.equals(usuarioLocatario);
    }
}

