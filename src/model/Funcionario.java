package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    }

    public void removerFuncionarioPeloNome(String nome){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome.toLowerCase()));

    }

    // Método para Imprimir todos os Funcionários através do toString().
    public void imprimirFuncionarios () {
        funcionarios.forEach(System.out::println);
    }

    // Método para Atualizar o salário dos funcionários com o aumento dado.
    public void atualizarSalarioComAumento (Double porcentagemAumento) {
        for (Funcionario funcionario : funcionarios) {
            BigDecimal aumento = funcionario.getSalario().multiply(BigDecimal.valueOf(porcentagemAumento / 100));
            funcionario.setSalario(funcionario.getSalario().add(aumento));
        }
    }
}
