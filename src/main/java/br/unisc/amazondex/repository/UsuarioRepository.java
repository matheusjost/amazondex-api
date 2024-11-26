package br.unisc.amazondex.repository;

import br.unisc.amazondex.entity.Usuario;
import br.unisc.amazondex.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);

    Usuario findByLogin(String login);

    List<Usuario> findByRole(RoleEnum role);
}
