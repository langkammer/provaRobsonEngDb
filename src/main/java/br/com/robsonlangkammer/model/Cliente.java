package br.com.robsonlangkammer.model;

import javax.persistence.*;

@Entity
public class Cliente {


    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String cpf;

    private String sexo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vendedor vendedor;

    public Cliente(){

    }

    public Cliente(String nome, String cpf, String sexo, Vendedor vendedor) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


}
