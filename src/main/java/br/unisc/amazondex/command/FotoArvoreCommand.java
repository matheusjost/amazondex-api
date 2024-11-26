package br.unisc.amazondex.command;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FotoArvoreCommand(
        Integer id,
        Integer fotoId,
        String descricao
) {
}
