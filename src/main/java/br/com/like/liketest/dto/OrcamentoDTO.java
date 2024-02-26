package br.com.like.liketest.dto;

import br.com.like.liketest.entities.ProdutoOrcamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;

public record OrcamentoDTO(
        @NotNull(message = "O nome do cliente é obrigatório")
        String nomeCliente,
        @NotNull(message = "A lista de produtos não pode estar vazia")
        ArrayList<ProdutoOrcamento> produtos,
        @NotNull(message = "A data do orçamento é obrigatória")
        String data,
        double total) {
}
