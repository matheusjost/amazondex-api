package br.unisc.amazondex.repository;

import br.unisc.amazondex.entity.Arvore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArvoreRepository extends JpaRepository<Arvore, Integer> {
}
