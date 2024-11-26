package br.unisc.amazondex.service;


import br.unisc.amazondex.entity.Usuario;
import br.unisc.amazondex.enums.RoleEnum;
import br.unisc.amazondex.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public List<RoleEnum> getRoles() {
        return List.of(RoleEnum.values());
    }

    public List<Usuario> getUsuarioByRole(RoleEnum role) {
        return usuarioRepository.findByRole(role);
    }

}
