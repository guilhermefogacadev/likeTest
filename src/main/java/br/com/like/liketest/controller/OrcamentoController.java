package br.com.like.liketest.controller;

import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import br.com.like.liketest.repository.OrcamentoRepository;
import br.com.like.liketest.repository.ProdutoOrcamentoRepository;
import br.com.like.liketest.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("api/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoRepository repositoryOrcamento;
    @Autowired
    private ProdutoOrcamentoRepository repositoryProduto;

    @Autowired
    private OrcamentoService orcamentoService;
    @PostMapping("/criar")
    public ResponseEntity criarOrcamento(@RequestBody OrcamentoDTO request){
        OrcamentoDTO result = orcamentoService.salvarOrcamento(request);

        return ResponseEntity.status(201).build();

    }
    @PostMapping("/proposta")
    public ResponseEntity<OrcamentoDTO> propostaOrcamento(@RequestBody OrcamentoDTO request){

        OrcamentoDTO response =orcamentoService.propostaOrcamento(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<OrcamentoDTO>> buscarTodos() {
        List<OrcamentoDTO> result =orcamentoService.buscaTodos();

        return ResponseEntity.ok(result);

    }
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<OrcamentoDTO> buscarPorId(@PathVariable(value="id") Long id) {

       OrcamentoDTO orcamento = orcamentoService.buscarPorId(id);
        return ResponseEntity.ok(orcamento);

    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity excluirOrcamento(@PathVariable(value="id") Long id) {

        orcamentoService.delete(id);
        return ResponseEntity.status(202).build();
    }





}
