import model.entities.Funcionario;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {

    public void executarAcoesDoTeste () {

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

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
        funcionariosPorFuncao = funcionarios.agruparFuncionariosPorFuncao(funcionariosPorFuncao);


        // 3.6 – Imprimir os funcionários, agrupados por função.
        funcionarios.imprimirFuncionariosAgrupadosPorFuncao(funcionariosPorFuncao);

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        funcionarios.funcionariosComAniversarioOutubroDezembro();

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        funcionarios.funcionarioMaisVelho();

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        funcionarios.imprimirFuncionariosPorOrdemAlfabetica();

        // 3.11 – Imprimir o total dos salários dos funcionários.
        funcionarios.totalSalariosDosFuncionarios();

        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        //funcionarios.imprimirQuantidadeSalariosMinimosFuncionario();
        //funcionarios.imprimirFuncionarios();
    }

}
