package br.unisc.amazondex.repository;

import br.unisc.amazondex.entity.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CultivoRepository extends JpaRepository<Cultivo, Integer> {
}
