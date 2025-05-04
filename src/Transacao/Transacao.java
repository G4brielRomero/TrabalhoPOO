package Transacao;
import java.time.LocalDate;
import Ferramenta.*;
import Usuario.*;
import Aluguel.*;
import java.time.temporal.ChronoUnit;

public class Transacao {
    private Usuario usuario;
    private Ferramenta ferramenta;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private int diasAtraso;
    private double multa;

    public Transacao(Aluguel aluguel) {
        this.usuario = aluguel.getLocatario(); 
        this.ferramenta = aluguel.getFerramenta();
        this.dataInicio = aluguel.getDataInicio();
        this.dataFim = aluguel.getDataFimReal();

        long atraso = ChronoUnit.DAYS.between(aluguel.getDataFimPrevista(), aluguel.getDataFimReal());
        this.diasAtraso = (int) (atraso > 0 ? atraso : 0);
        this.multa = atraso > 0 ? atraso * ferramenta.getPrecoPorDia() * 0.2 : 0.0;
    }
    
    public void exibirTransacao() {
        System.out.println("===== Detalhes da Transação =====");
        System.out.println("Usuário: " + usuario.getNome() + " (CPF: " + usuario.getCpf() + ")");
        System.out.println("Ferramenta: " + ferramenta.getNome());
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Data de Devolução: " + dataFim);
        System.out.println("Dias de Atraso: " + diasAtraso);
        System.out.printf("Multa: R$ %.2f%n", multa);
    }


}
