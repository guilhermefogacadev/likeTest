package br.com.like.liketest.controller;

import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import br.com.like.liketest.repository.OrcamentoRepository;
import br.com.like.liketest.repository.ProdutoOrcamentoRepository;
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
    @PostMapping("/criar")
    public ResponseEntity criarOrcamento(@RequestBody OrcamentoDTO request){
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


        return ResponseEntity.ok().build();

    }
    @PostMapping("/proposta")
    public ResponseEntity<OrcamentoDTO> propostaOrcamento(@RequestBody OrcamentoDTO request){
        double total= 0;
        for(ProdutoOrcamento produto:request.produtos()){
            total+=produto.getValor()*produto.getQuantidade();

        }
        OrcamentoDTO response =new OrcamentoDTO(request.nomeCliente(), request.produtos(), total);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/buscar")
    public ResponseEntity<List<Orcamento>> buscarTodos() {
        List<Orcamento> result = repositoryOrcamento.findAll();


        return ResponseEntity.ok(result);

    }
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<Orcamento> buscarPorId(@PathVariable(value="id") Long id) {
        Optional<Orcamento> orcamentoOptional = repositoryOrcamento.findById(id);

        if (orcamentoOptional.isPresent()) {
            Orcamento orcamento = orcamentoOptional.get();
            return ResponseEntity.ok(orcamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity excluirOrcamento(@PathVariable(value="id") Long id) {
        repositoryProduto.deleteById(id);
        return ResponseEntity.status(202).build();
    }





}
