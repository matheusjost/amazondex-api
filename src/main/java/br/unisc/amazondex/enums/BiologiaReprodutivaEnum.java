package br.unisc.amazondex.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BiologiaReprodutivaEnum {
    FRUTIFICACAO("Frutificação"),
    DISPERSAO("Dispersão");

    private final String descricao;

    public static BiologiaReprodutivaEnum getEnum(String descricao) {
        for (BiologiaReprodutivaEnum biologiaReprodutivaEnum : BiologiaReprodutivaEnum.values()) {
            if (biologiaReprodutivaEnum.getDescricao().equals(descricao)) {
                return biologiaReprodutivaEnum;
            }
        }
        return null;
    }

}
