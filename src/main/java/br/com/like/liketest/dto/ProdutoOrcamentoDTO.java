package br.com.like.liketest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProdutoOrcamentoDTO(
        @NotNull(message = "Campo nome não pode ser nulo")
        @Size(max = 200,message = "Numero maior que os caracteres permitidos, seu máximo é 200")
        String nome ,
        @NotNull(message = "Campo nome não pode ser nulo")
        double valor,
        @NotNull(message = "Campo nome não pode ser nulo")
        int quantidade) {
}
