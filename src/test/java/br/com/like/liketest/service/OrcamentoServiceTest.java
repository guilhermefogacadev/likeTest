package br.com.like.liketest.service;


import br.com.like.liketest.CriaObjeto.CriaObjeto;
import br.com.like.liketest.dto.OrcamentoDTO;

import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;

import br.com.like.liketest.service.OrcamentoService;
import br.com.like.liketest.service.ProdutoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@DataJpaTest
@ActiveProfiles("test")
class OrcamentoServiceTest {

    EntityManager entityManager;
    @Mock
    OrcamentoService orcamentoService;
    @Mock
    ProdutoService produtoService;

    Orcamento orcamento;
    ArrayList<ProdutoOrcamento> produtos;
    OrcamentoDTO orcamentoDTO;
    CriaObjeto criaObjeto = new CriaObjeto();

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this); // Inicializa os mocks

        orcamento = criaObjeto.criarOrcamento();
        produtos= criaObjeto.criarListaProduto(orcamento);
        orcamentoDTO = criaObjeto.criarOrcamentoDTO(orcamento,produtos);

        doNothing().when(produtoService).salvaProduto(any(OrcamentoDTO.class), any(Orcamento.class));


        when(orcamentoService.salvarOrcamento(any(OrcamentoDTO.class))).thenReturn(orcamentoDTO);
    }


    @Test
    void salvarOrcamento() {
        when(orcamentoService.salvarOrcamento(orcamentoDTO)).thenReturn((orcamentoDTO));
        OrcamentoDTO salvo = orcamentoService.salvarOrcamento(orcamentoDTO);
        assertSame(orcamentoDTO, salvo);

    }



    @Test
    void buscaTodos() {
        when(orcamentoService.buscaTodos()).thenReturn(Collections.singletonList(orcamentoDTO));
        List<OrcamentoDTO>result= orcamentoService.buscaTodos();
        assertEquals(1,result.size());
    }

    @Test
    void buscarPorId() {
        when(orcamentoService.buscarPorId(1L)).thenReturn((orcamentoDTO));
        OrcamentoDTO result= orcamentoService.buscarPorId(1L);

        assertEquals(result,orcamentoDTO);
    }

    @Test
    void delete() {
    }

}