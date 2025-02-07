package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

        return "Funcionario:\n " +
                "Nome: " + this.getNome() +
                " | Data de Nascimento: " + this.getDataNascimento() +
                " | Salário: " + salario +
                " | Funcao: " + funcao;
    }

    public void adicionarFuncionario (String nome, String dataNascimento, BigDecimal salario, String funcao){
        funcionarios.add(new Funcionario(nome, dataNascimento, salario, funcao));
    }

    public void removerFuncionarioPeloNome(String nome){
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase(nome.toLowerCase()));

    }

    public void imprimirFuncionarios () {
        funcionarios.forEach(System.out::println);
    }

}
