package br.unisc.amazondex.repository;

import br.unisc.amazondex.entity.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
}
