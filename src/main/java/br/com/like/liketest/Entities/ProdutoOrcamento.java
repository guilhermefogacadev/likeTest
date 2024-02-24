package br.com.like.liketest.Entities;

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
    private int valor;



    public ProdutoOrcamento() {
    }

    public ProdutoOrcamento(Long id, String nome, int valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
