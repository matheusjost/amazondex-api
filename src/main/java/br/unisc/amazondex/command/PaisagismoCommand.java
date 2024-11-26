package br.unisc.amazondex.command;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaisagismoCommand extends ComboCommand {
    private PaisagismoFotoCommand paisagismoFotoCommand;
}
