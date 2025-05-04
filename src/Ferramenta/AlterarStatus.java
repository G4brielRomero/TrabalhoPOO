/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ferramenta;
import java.util.ArrayList;
/**
 *
 * @author muril
 */
public class AlterarStatus {
    public void alteracaoStatus(ArrayList<Ferramenta> ferramenta, String nome, String novoStatus){
        for(Ferramenta f : ferramenta){
            if(f.getNome().equals(nome)){
                f.setStatus(novoStatus);
                System.out.println("Novo status atualizado.\n");
            }
        }
    }
}