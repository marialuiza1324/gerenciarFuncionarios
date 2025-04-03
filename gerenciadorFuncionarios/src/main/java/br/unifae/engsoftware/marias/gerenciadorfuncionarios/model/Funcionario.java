package br.unifae.engsoftware.marias.gerenciadorfuncionarios.model;

import java.util.Objects;

/**
 *
 * @author Maria Eduarda de Oliveira Furini e Maria Luiza Nery Pinto
 */
public class Funcionario {
    public String codigo;
    private String nome;
    private double salario;
    
    public Funcionario(){}

    public Funcionario(String codigo, String nome, double salario){
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
    @Override
    public String toString(){
        return codigo + "\n" +
                nome + "\n" +
                salario + "\n";
    }
}