package br.com.like.liketest.service;

import br.com.like.liketest.dto.OrcamentoDTO;
import br.com.like.liketest.entities.Orcamento;
import br.com.like.liketest.entities.ProdutoOrcamento;
import br.com.like.liketest.repository.OrcamentoRepository;
import br.com.like.liketest.repository.ProdutoOrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository repositoryOrcamento;
    @Autowired
    private ProdutoOrcamentoRepository repositoryProduto;
    @Autowired
    private ProdutoService ProdutoService;
    public OrcamentoDTO salvarOrcamento(OrcamentoDTO request){
        Orcamento template = new Orcamento(request.nomeCliente(), LocalDate.now().toString());
        Orcamento orcamento=repositoryOrcamento.save(template);

        ProdutoService.salvaProduto(request,orcamento);

        return new OrcamentoDTO(request.nomeCliente(),request.produtos(),request.data(),calculaTotal(request.produtos()));

    }
    public OrcamentoDTO propostaOrcamento(OrcamentoDTO request){
        double total= calculaTotal(request.produtos());
        return new OrcamentoDTO(request.nomeCliente(), request.produtos(),request.data(), total);

    }

    public List<OrcamentoDTO> buscaTodos(){
        List<Orcamento>busca = repositoryOrcamento.findAll();

        List<OrcamentoDTO> orcamentos= new ArrayList<>();

        for(Orcamento orcamento:busca){
            ArrayList<ProdutoOrcamento>produto= ProdutoService.buscarPorOrcamento(orcamento);
            OrcamentoDTO orcamentoDTO= new OrcamentoDTO(orcamento.getNomeCliente(),produto,orcamento.getData(),calculaTotal(produto));
            orcamentos.add(orcamentoDTO);
        }


        return orcamentos;
    }
    public OrcamentoDTO buscarPorId( Long id) {


        Optional<Orcamento> orcamentoOptional = repositoryOrcamento.findById(id);
        Orcamento orcamento= orcamentoOptional.get();

        ArrayList<ProdutoOrcamento>produto= ProdutoService.buscarPorOrcamento(orcamento);

        return new OrcamentoDTO(orcamentoOptional.get().getNomeCliente(),produto, orcamentoOptional.get().getData(),calculaTotal(produto));

    }

    public void delete( Long id) {

        repositoryProduto.deleteById(id);


    }

    public double calculaTotal(ArrayList<ProdutoOrcamento> produtos) {
        double total= 0;
        for(ProdutoOrcamento produto:produtos){
            total+=produto.getValor()*produto.getQuantidade();
        }
        return total;
    }
}
