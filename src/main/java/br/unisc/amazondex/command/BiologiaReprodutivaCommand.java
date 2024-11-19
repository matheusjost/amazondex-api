package br.unisc.amazondex.command;

import br.unisc.amazondex.enums.BiologiaReprodutivaEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BiologiaReprodutivaCommand(Integer id, BiologiaReprodutivaEnum tipo, String descricao) {
}
