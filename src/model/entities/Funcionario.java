package model.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public Funcionario (){

    }

    public Funcionario(String nome, String dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(salario, that.salario) && Objects.equals(funcao, that.funcao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario, funcao);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("Nome: %s, Data Nascimento: %s, Salário: %,.2f, Função: %s",
                this.getNome(), this.getDataNascimento().format(formatter), salario, funcao);
    }

    public void adicionarFuncionario (String nome, String dataNascimento, BigDecimal salario, String funcao){
        funcionarios.add(new Funcionario(nome, dataNascimento, salario, funcao));
        System.out.printf("• Funcionário %s adicionado com Sucesso!\n", funcionarios.getLast().getNome());
    }

    public void removerFuncionarioPeloNome(String nome){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome.toLowerCase()));
        System.out.printf("• Funcionário %s Removido com Sucesso", nome);
    }

    // Método para Imprimir todos os Funcionários através do toString().
    public void imprimirFuncionarios () {
        funcionarios.forEach(System.out::println);
    }

    // Método para Atualizar o salário dos funcionários com o aumento passado pelo parametro.
    public void atualizarSalarioComAumento (Double porcentagemAumento) {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(BigDecimal.valueOf(porcentagemAumento / 100));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }
    }

    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        System.out.println("Funcionários foram agrupados por Função exercida.");
        return funcionariosPorFuncao;

    }

    public void imprimirFuncionariosAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(System.out::println);
        });
    }

    public void funcionariosComAniversarioOutubroDezembro() {
        List<Funcionario> aniversariantesOutubroDezembro = new ArrayList<>();
        System.out.println("\nFuncionários que fazem aniversário em outubro e dezembro:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12){
                aniversariantesOutubroDezembro.add(funcionario);
            }
        }
        aniversariantesOutubroDezembro.forEach(System.out::println);
    }

    public void funcionarioMaisVelho() {
        LocalDate anoAtual = LocalDate.now();
        int idade = 0;
        Funcionario funcionarioMaisVelho = new Funcionario();
        funcionarioMaisVelho.setDataNascimento(LocalDate.now());
        for (Funcionario funcionario : funcionarios) {
            if(Year.of(funcionario.getDataNascimento().getYear()).getValue() < Year.of(funcionarioMaisVelho.getDataNascimento().getYear()).getValue()) {
                funcionarioMaisVelho = funcionario;
                idade = Year.of(anoAtual.getYear()).getValue() - Year.of(funcionario.getDataNascimento().getYear()).getValue();
            }
        }
        System.out.println("O funcionário mais velho da empresa é o(a) " + funcionarioMaisVelho.getNome() + " com " + idade + " anos de idade!");
    }

    public void imprimirFuncionariosPorOrdemAlfabetica() {
        System.out.println("\nLista de Funcionários por Ordem Alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);
    }

    public void totalSalariosDosFuncionarios() {
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for(Funcionario funcionario : funcionarios) {
            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }
        System.out.printf("\nTotal dos salários: R$ %,.2f\n", totalSalarios);
    }

    public void imprimirQuantidadeSalariosMinimosFuncionario() {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nQuantidade de salários mínimos por funcionário:");

        for(Funcionario funcionario : funcionarios) {
            BigDecimal qtdSalariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("%s: %.2f salários mínimos\n", funcionario.getNome(), qtdSalariosMinimos);
        }

    }

}
