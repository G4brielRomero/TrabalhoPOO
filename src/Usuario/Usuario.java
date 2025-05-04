package Usuario;
import java.util.ArrayList;
import Ferramenta.*;

public class Usuario {
    private String nome;
    private String contato;
    private String cpf;
    private ArrayList<Ferramenta> listaDeFerramentas;

    public Usuario(String nome, String contato, String cpf) {
        this.nome = nome;
        this.contato = contato;
        this.cpf = cpf;
        this.listaDeFerramentas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }    
    
    public String exibirUsuario() {
        String dados =  "Nome: " + this.nome + "\nContato: " + this.contato + "\nCPF: " + this.cpf + "\n";
        if(listaDeFerramentas.isEmpty()){
            dados += "Nenhuma ferramenta cadastrada.\n";
        }else{
            for(Ferramenta f : listaDeFerramentas){
                dados += f.exibirFerramenta() + "\n";
            }
        }
        return dados;
    }
    
    // Método para adicionar uma ferramenta ao usuário
    public boolean adicionarFerramenta(Ferramenta ferramenta) {
        if (listaDeFerramentas.size() >= 5) {
            System.out.println("Limite máximo de 5 ferramentas atingido para o usuário: " + nome);
            return false;
        }
        for (Ferramenta f : listaDeFerramentas) {
            if (f.getNome().equalsIgnoreCase(ferramenta.getNome())) {
                System.out.println("Já existe uma ferramenta com esse nome para o usuário: " + nome);
                return false;
            }
        }
        listaDeFerramentas.add(ferramenta);
        return true;
    }
    
    public boolean removerFerramenta(String nomeFerramenta){
        for(Ferramenta f : listaDeFerramentas){
            if(f.getNome().equalsIgnoreCase(nomeFerramenta)){
                listaDeFerramentas.remove(f);
                return true;
            }
        }
        return false;
    }
    
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Usuario usuario = (Usuario) obj;
        return this.cpf.equals(usuario.cpf);
    }
    
    public int hashCode(){
        return cpf.hashCode();
    }

}