package br.com.like.liketest.dto;

import br.com.like.liketest.entities.ProdutoOrcamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;

public record OrcamentoDTO(String nomeCliente, ArrayList<ProdutoOrcamento> produtos, String data,double total) {
}
