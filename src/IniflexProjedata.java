import model.Funcionario;

import java.math.BigDecimal;


public class IniflexProjedata {
    public static void main(String[] args) {

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela do Teste.
        Funcionario funcionarios = new Funcionario();
        funcionarios.adicionarFuncionario("Maria",  "18/10/2000", new BigDecimal("2009.44"), "Operador");
        funcionarios.adicionarFuncionario("João", "12/05/1990", new BigDecimal("2284.38"), "Operador");
        funcionarios.adicionarFuncionario("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador");
        funcionarios.adicionarFuncionario("Miguel", "14/10/1988", new BigDecimal("19119.88"), "Diretor");
        funcionarios.adicionarFuncionario("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista");
        funcionarios.adicionarFuncionario("Heitor", "19/11/1999", new BigDecimal("1582.72"), "Operador");
        funcionarios.adicionarFuncionario("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador");
        funcionarios.adicionarFuncionario("Laura", "08/07/1994", new BigDecimal("3017.45"), "Gerente");
        funcionarios.adicionarFuncionario("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista");
        funcionarios.adicionarFuncionario("Helena", "02/09/1996", new BigDecimal("2799.93"), "Gerente");

        // 3.2 – Remover o funcionário “João” da lista.
        funcionarios.removerFuncionarioPeloNome("joão");

        /*
         * 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
         * • informação de data deve ser exibido no formato dd/mm/aaaa;
         * • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
         */
        funcionarios.imprimirFuncionarios();

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        funcionarios.atualizarSalarioComAumento(10.0);

        
        funcionarios.imprimirFuncionarios();
    }
}