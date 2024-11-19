package br.unisc.amazondex.command;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ArvoreCommand(
        Integer id,
        String nome,
        String descricaoBotanica,
        String aspectosEcologicos,
        String regeneracaoNatural,
        BiologiaReprodutivaCommand biologiaReprodutivaCommand,
        List<OcorrenciaNaturalCommand> ocorrenciaNaturalCommand,
        List<FotoArvoreCommand> fotoArvoreCommand,
        CultivoCommand cultivoCommand,
        PaisagismoCommand paisagismoCommand,
        AproveitamentoCommand aproveitamentoCommand
) {}














