package br.unisc.amazondex.repository;

import br.unisc.amazondex.entity.Alimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Integer> {
}
