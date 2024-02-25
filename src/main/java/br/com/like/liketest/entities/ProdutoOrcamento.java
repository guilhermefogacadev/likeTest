package br.com.like.liketest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="/produtoOrcamento")
public class ProdutoOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String nome;
    @Column()
    private double valor;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;


    @JsonIgnore
    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public ProdutoOrcamento() {
    }


    public ProdutoOrcamento( Long id, String nome, double valor,int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade=quantidade;
    }
    public ProdutoOrcamento( String nome, double valor,int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade=quantidade;
    }


    @JsonIgnore

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
