package br.com.like.liketest.repository;

import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoOrcamentoRepository extends JpaRepository<ProdutoOrcamento,Long> {
    ArrayList<ProdutoOrcamento> findAllByOrcamento(Orcamento orcamento);

}
