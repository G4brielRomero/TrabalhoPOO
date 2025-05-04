package Aluguel;
import java.time.LocalDate;
import java.util.ArrayList;
import Ferramenta.*;
import Usuario.*;
import Transacao.*;

public class Aluguel {
    private Usuario locador;
    private Usuario locatario;
    private Ferramenta ferramenta;
    private LocalDate dataInicio;
    private LocalDate dataFimPrevista;
    private LocalDate dataFimReal;
    private double valorTotal;

    public Aluguel(Usuario locador, Usuario locatario, Ferramenta ferramenta, LocalDate dataInicio, LocalDate dataFimPrevista) {
        this.locador = locador;
        this.locatario = locatario;
        this.ferramenta = ferramenta;
        this.dataInicio = dataInicio;
        this.dataFimPrevista = dataFimPrevista;
    }

    public void registrarDevolucao(LocalDate dataDevolucao) {
        this.dataFimReal = dataDevolucao;

        long diasPrevistos = java.time.temporal.ChronoUnit.DAYS.between(dataInicio, dataFimPrevista);
        long diasUsados = java.time.temporal.ChronoUnit.DAYS.between(dataInicio, dataDevolucao);
        if (diasUsados < 1) 
            diasUsados = 1; // deve ter no mínimo 1 dia de uso.

        double diaria = ferramenta.getPrecoPorDia();
        double valorBase = diaria * diasUsados;

        double multa = 0.0;
        if (dataDevolucao.isAfter(dataFimPrevista)) {
            long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(dataFimPrevista, dataDevolucao);
            multa = diasAtraso * diaria * 0.2; // 20% da diária por dia de atraso
        }

        this.valorTotal = valorBase + multa;
    }

    public Usuario getLocador() {
        return locador;
    }

    public Usuario getLocatario() {
        return locatario;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFimPrevista() {
        return dataFimPrevista;
    }

    public LocalDate getDataFimReal() {
        return dataFimReal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    
    
}