package br.unisc.amazondex.command;

import br.unisc.amazondex.enums.TipoCuidadoEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuidadosEspeciaisCommand extends ComboCommand {
    private TipoCuidadoEnum tipoCuidado;
}
