package Ej11_academicos;

import java.util.Objects;

public class Academico implements Comparable<Academico> {
    private String nome;
    private int anoIngreso;

    public Academico(String nome, int anoIngreso){
        this.nome = nome;
        this.anoIngreso = anoIngreso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    public void setAnoIngreso(int anoIngreso){
        this.anoIngreso = anoIngreso;
    }

    @Override
    public int compareTo(Academico outro) {
        return this.nome.compareTo(outro.getNome());
    }

    @Override
    public String toString() {
        return nome + " (Ingreso: " + anoIngreso + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Academico academico = (Academico) o;
        return Objects.equals(nome, academico.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
