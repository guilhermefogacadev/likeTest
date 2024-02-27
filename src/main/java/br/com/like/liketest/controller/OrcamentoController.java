package br.com.like.liketest.controller;



import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.service.OrcamentoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@OpenAPIDefinition(info = @Info(title = "API de Orçamentos", description = "API desenvolvida para o teste LikeSystema"))
@RequestMapping("api/orcamento")
public class OrcamentoController {


    @Autowired
    private OrcamentoService orcamentoService;

    @Operation(summary = "Criação dos Orçamentos", method = "POST")
    @PostMapping("/criar")
    public ResponseEntity criarOrcamento(@Valid @RequestBody OrcamentoDTO request){
        OrcamentoDTO result = orcamentoService.salvarOrcamento(request);

        return ResponseEntity.status(201).build();

    }
    @Operation(summary = "Proposta de Orçamento", method = "POST")
    @PostMapping("/proposta")
    public ResponseEntity<OrcamentoDTO> propostaOrcamento(@Valid @RequestBody OrcamentoDTO request){

        OrcamentoDTO response =orcamentoService.propostaOrcamento(request);
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Listagem de Orçamentos", method = "GET")
    @GetMapping(value = "/buscar")

    public ResponseEntity<List<OrcamentoDTO>> buscarTodos() {
        List<OrcamentoDTO> orcamentos =orcamentoService.buscaTodos();

        if(orcamentos.isEmpty()){
                return ResponseEntity.status(404).body(orcamentos);
        }
        return ResponseEntity.ok(orcamentos);

    }
    @Operation(summary = "Listagem de Orçamentos por ID", method = "GET")
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<OrcamentoDTO> buscarPorId(@PathVariable(value="id") Long id) {

       OrcamentoDTO orcamento = orcamentoService.buscarPorId(id);

        return ResponseEntity.ok(orcamento);

    }

    @Operation(summary = "Exclusão de Orçamentos por ID", method = "DELETE")
    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity excluirOrcamento(@PathVariable(value="id") Long id) {

        orcamentoService.delete(id);
        return ResponseEntity.status(202).build();
    }





}
