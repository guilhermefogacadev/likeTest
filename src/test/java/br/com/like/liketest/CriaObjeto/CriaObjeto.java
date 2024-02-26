package br.com.like.liketest.CriaObjeto;

import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.dto.ProdutoOrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CriaObjeto {


    public CriaObjeto() {

    }

    EntityManager entityManager;

    public Orcamento criarOrcamento(){

        return new Orcamento("Guilherme", LocalDate.now().toString());
    }
    public OrcamentoDTO criarOrcamentoDTO(Orcamento orcamento, ArrayList<ProdutoOrcamento> produtos){
        return new OrcamentoDTO(orcamento.getNomeCliente(),produtos,LocalDate.now().toString(),calculaTotal(produtos));
    }
    public ProdutoOrcamentoDTO criarProdutoOrcamentoDTO(ArrayList<ProdutoOrcamento> produto){
        return new ProdutoOrcamentoDTO(produto.get(0).getNome(), produto.get(0).getValor(),produto.get(0).getQuantidade());
    }
    public ArrayList<ProdutoOrcamento> criarListaProduto(Orcamento orcamento){
        ArrayList<ProdutoOrcamento> produtos= new ArrayList<>();
        ProdutoOrcamento produto1= new ProdutoOrcamento("Computador I3",1000.00,1);
        produto1.setOrcamento(orcamento);
        ProdutoOrcamento produto2= new ProdutoOrcamento("Computador I5",2000.00,1);
        produto2.setOrcamento(orcamento);
        produtos.add(produto1);
        produtos.add(produto2);

        return produtos;
    }

    public double calculaTotal(ArrayList<ProdutoOrcamento> produtos) {
        double total= 0;
        for(ProdutoOrcamento produto:produtos){
            total+=produto.getValor()*produto.getQuantidade();
        }
        return total;
    }


}
