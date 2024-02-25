package br.com.like.liketest.service;

import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import br.com.like.liketest.repository.OrcamentoRepository;
import br.com.like.liketest.repository.ProdutoOrcamentoRepository;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;


public class OrcamentoService {

    private OrcamentoRepository repositoryOrcamento;
    private ProdutoOrcamentoRepository repositoryProduto;
    public void salvarOrcamento(OrcamentoDTO request){
        Orcamento template = new Orcamento(request.nomeCliente(), LocalDate.now().toString());
        Orcamento orcamento=repositoryOrcamento.save(template);

        request.produtos().forEach(produtos ->{
            ProdutoOrcamento produto = new ProdutoOrcamento();
            produto.setOrcamento(orcamento);
            produto.setNome(produtos.getNome());
            produto.setValor(produtos.getValor());
            produto.setQuantidade(produtos.getQuantidade());
            repositoryProduto.save(produto);
        });

    }
}
