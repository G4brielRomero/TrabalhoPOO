package Usuario;

public class ValidadorCPF {
    public static boolean isCPF(String cpf) {
        // Remove caracteres não numéricos
        if (cpf == null) {
            return false;
        }
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se tem 11 dígitos ou é uma sequência inválida
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int digito = cpf.charAt(i) - '0';
            soma += digito * (10 - i);
        }

        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito >= 10) primeiroDigito = 0;

        if (primeiroDigito != (cpf.charAt(9) - '0')) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            int digito = cpf.charAt(i) - '0';
            soma += digito * (11 - i);
        }

        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito >= 10) segundoDigito = 0;

        return segundoDigito == (cpf.charAt(10) - '0');
    }
}


