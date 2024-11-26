package br.unisc.amazondex.command;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record AlimentacaoCommand(
        Integer id,
        String dadosNutricionais,
        String formasConsumo
) {
}
