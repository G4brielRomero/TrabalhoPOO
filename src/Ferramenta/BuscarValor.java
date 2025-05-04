package Ferramenta;

public class BuscarValor {
    public static double getPrecoMinino(String categoria){
        if(categoria == null)
            return -1;
        
        return switch(categoria.trim().toLowerCase())
        {
            case "elétrica", "eletrica" -> 15.0;
            case "manual" -> 8.0;
            case "jardim" -> 12.00;
            default -> -1;
        };
    }
}
