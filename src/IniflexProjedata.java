import model.Funcionario;

import java.math.BigDecimal;

public class IniflexProjedata {
    public static void main(String[] args) {

        // Inserir todos os funcionários, na mesma ordem e informações da tabela do Teste.
        new Funcionario("Maria",  "18/10/2000", new BigDecimal("2009.44"), "Operador");
        new Funcionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador");
        new Funcionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador");
        new Funcionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor");
        new Funcionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista");
        new Funcionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador");
        new Funcionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador");
        new Funcionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente");
        new Funcionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista");
        new Funcionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente");
    }
}