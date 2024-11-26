package br.unisc.amazondex.command;

import lombok.Data;

@Data
abstract class ComboCommand {
    private Integer id;
    private String descricao;
}
