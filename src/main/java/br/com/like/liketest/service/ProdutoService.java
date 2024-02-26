package br.com.like.liketest.service;

import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import br.com.like.liketest.repository.ProdutoOrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoOrcamentoRepository repositoryProduto;

    protected void salvaProduto(OrcamentoDTO request, Orcamento orcamento) {
        request.produtos().forEach(produtos ->{
            ProdutoOrcamento produto = new ProdutoOrcamento();
            produto.setOrcamento(orcamento);
            produto.setNome(produtos.getNome());
            produto.setValor(produtos.getValor());
            produto.setQuantidade(produtos.getQuantidade());
            repositoryProduto.save(produto);
        });
    }


    protected ArrayList<ProdutoOrcamento> buscarPorOrcamento(Orcamento orcamento) {

        ArrayList<ProdutoOrcamento> produto = repositoryProduto.findAllByOrcamento(orcamento);
        return produto;

    }
}
