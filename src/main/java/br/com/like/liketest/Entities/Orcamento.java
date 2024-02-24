package br.com.like.liketest.Entities;

import jakarta.persistence.*;

@Entity
@Table(name ="orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeCliente;
    @Column
    private String data;

    public Orcamento() {
    }

    public Orcamento(Long id, String nomeCliente, String data) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
