package Ferramenta;
import java.util.ArrayList;

public class Ferramenta {
    private String nome;
    private String descricao;
    private double precoPorDia;
    private String categoria;
    private String status;
    private boolean disponivel = true;

    public Ferramenta(String nome, String descricao, double precoPorDia, String categoria, String status) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoPorDia = precoPorDia;
        this.categoria = categoria;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoPorDia(double precoPorDia) {
        this.precoPorDia = precoPorDia;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean isDisponivel(){
        return disponivel;
    }
    
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    
    public boolean equals(Object obj) {
        // Verifica se o objeto é a mesma instância
        if (this == obj) {
            return true;
        }

        // Verifica se o objeto é uma instância de Ferramenta
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Faz o cast para Ferramenta
        Ferramenta other = (Ferramenta) obj;

        // Compara os nomes das ferramentas
        return nome != null && nome.equals(other.nome);
    }

    
    public String exibirFerramenta() {
        return "Nome: " + nome +
               "\nDescrição: " + descricao +
               "\nPreço por dia: R$ " + precoPorDia +
               "\nCategoria: " + categoria +
               "\nStatus: " + status;
    }

}