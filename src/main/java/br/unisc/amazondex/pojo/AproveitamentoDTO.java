package br.unisc.amazondex.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface AproveitamentoDTO extends ComboDTO {
    BiotecnologiaDTO getBiotecnologia();
    AlimentacaoDTO getAlimentacao();
    BioatividadeDTO getBioatividade();
}
