package br.unisc.amazondex.security;

import br.unisc.amazondex.enums.RoleEnum;

public record LoginResponseDTO(Integer id, String token, RoleEnum role, String login) {
}
