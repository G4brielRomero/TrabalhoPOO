package Aluguel;
import javax.swing.JOptionPane;
import Usuario.*;

public class VerificaIdade {
    public boolean VerificarIdade(Usuario usuario, String categoria){
        String dado;
        dado = JOptionPane.showInputDialog("Digite a sua idade:");
        
        int idade;
        idade = Integer.parseInt(dado);
        
        if (idade < 18 && categoria.equalsIgnoreCase("Eletrica")) {
            JOptionPane.showMessageDialog(null, 
                "Você precisa ter 18 anos ou mais para alugar ferramentas elétricas.",
                "Restrição de Idade", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}