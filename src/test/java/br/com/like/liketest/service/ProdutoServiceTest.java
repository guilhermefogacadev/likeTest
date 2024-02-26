package br.com.like.liketest.service;

import br.com.like.liketest.CriaObjeto.CriaObjeto;
import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.dto.ProdutoOrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@DataJpaTest
@ActiveProfiles("test")
class ProdutoServiceTest {

    EntityManager entityManager;
    @Mock
    OrcamentoService orcamentoService;
    @Mock
    ProdutoService produtoService;

    Orcamento orcamento;
    ArrayList<ProdutoOrcamento> produtos;
    OrcamentoDTO orcamentoDTO;
    ProdutoOrcamentoDTO produtoDTO;
    CriaObjeto criaObjeto = new CriaObjeto();

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this); // Inicializa os mocks

        orcamento = criaObjeto.criarOrcamento();
        produtos= criaObjeto.criarListaProduto(orcamento);
        orcamentoDTO = criaObjeto.criarOrcamentoDTO(orcamento,produtos);
        produtoDTO= criaObjeto.criarProdutoOrcamentoDTO(produtos);



        when(produtoService.buscarPorOrcamento(orcamento)).thenReturn(produtos);
    }

    @Test
    void salvaProduto() {
        when(produtoService.salvaProduto(orcamentoDTO, orcamento)).thenReturn(produtos);
        List<ProdutoOrcamento> salvo = produtoService.salvaProduto(orcamentoDTO,orcamento);
        assertSame(produtos, salvo);
    }

    @Test
    void buscarPorOrcamento() {
        ArrayList<ProdutoOrcamento>result=produtoService.buscarPorOrcamento(orcamento);

        int i=0;
        for(ProdutoOrcamento produto:result){
            assertEquals(result.get(i),orcamentoDTO.produtos().get(i));
            i++;
        }
    }
}