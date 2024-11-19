package br.unisc.amazondex.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CultivoCommand extends ComboCommand {
    private List<CuidadosEspeciaisCommand> cuidadosEspeciaisCommand;
}
