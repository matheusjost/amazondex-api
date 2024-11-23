package br.unisc.amazondex.pojo;

import br.unisc.amazondex.enums.BiologiaReprodutivaEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface BiologiaReprodutivaDTO extends ComboDTO {
    BiologiaReprodutivaEnum getTipo();
}
