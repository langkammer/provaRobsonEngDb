package br.com.robsonlangkammer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vendedor {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String cpf;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RELACAO_VENDEDOR_CLIENTE",
            joinColumns = @JoinColumn(name = "vendedor_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes;


    public Vendedor(){

    }

    public Vendedor(String nome, String cpf, List<Cliente> clientes) {
        this.nome = nome;
        this.cpf = cpf;
        this.clientes = clientes;
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }




}
