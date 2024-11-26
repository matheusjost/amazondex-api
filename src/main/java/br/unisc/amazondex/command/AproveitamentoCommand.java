package br.unisc.amazondex.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AproveitamentoCommand extends ComboCommand {
    private BiotecnologiaCommand biotecnologiaCommand;
    private AlimentacaoCommand alimentacaoCommand;
    private BioatividadeCommand bioatividadeCommand;
}
