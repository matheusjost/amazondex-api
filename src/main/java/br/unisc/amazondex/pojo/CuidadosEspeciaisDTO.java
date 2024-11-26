package br.unisc.amazondex.pojo;

import br.unisc.amazondex.enums.TipoCuidadoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface CuidadosEspeciaisDTO extends ComboDTO {
    TipoCuidadoEnum getTipoCuidado();
}
