package br.unisc.amazondex.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoCuidadoEnum {
    AGUA("Água"),
    SOLO("Solo");

    private final String descricao;

    public static TipoCuidadoEnum getEnum(String descricao) {
        for (TipoCuidadoEnum tipoCuidado : TipoCuidadoEnum.values()) {
            if (tipoCuidado.getDescricao().equalsIgnoreCase(descricao)) {
                return tipoCuidado;
            }
        }
        return null;
    }
}
