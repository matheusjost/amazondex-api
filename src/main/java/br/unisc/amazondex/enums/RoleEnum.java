package br.unisc.amazondex.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum {
    ADMINISTRADOR("administrador"),
    BIOLOGO("biologo"),
    ALUNO("aluno");

    private String role;

    public static RoleEnum fromString(String value) {
        for (RoleEnum b : RoleEnum.values()) {
            if (b.role.equalsIgnoreCase(value)) {
                return b;
            }
        }
        return null;
    }

}
