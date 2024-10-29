package br.unisc.amazondex.security;

import br.unisc.amazondex.enums.RoleEnum;

public record RegisterDTO(String login, String senha, String nome, String email, RoleEnum role) {
}
