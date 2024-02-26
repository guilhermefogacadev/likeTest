package br.com.like.liketest.repository;

import br.com.like.liketest.CriaObjeto.CriaObjeto;
import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import br.com.like.liketest.service.OrcamentoService;
import br.com.like.liketest.service.ProdutoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@ActiveProfiles("test")
class ProdutoOrcamentoRepositoryTest {
    @Autowired
    EntityManager entityManager;
    @Autowired
    ProdutoOrcamentoRepository produtoOrcamentoRepository;
    @Autowired
    OrcamentoRepository orcamentoRepository;
    CriaObjeto criaObjeto = new CriaObjeto();
    @Test
    @DisplayName("Consulta do Orçamento no Banco de Dados")
    void findAllByOrcamentoTest() {

        Orcamento orcamento =criaObjeto.criarOrcamento();
        orcamentoRepository.save(orcamento);

        List<ProdutoOrcamento> produtos= criaObjeto.criarListaProduto(orcamento);
        produtoOrcamentoRepository.saveAll(produtos);

        ArrayList<ProdutoOrcamento> result= produtoOrcamentoRepository.findAllByOrcamento(orcamento);

        assertEquals(2, result.size());
        assertEquals(produtos.get(0), result.get(0));
        assertEquals(produtos.get(1), result.get(1));



    }


}