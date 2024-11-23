package br.unisc.amazondex.repository;

import br.unisc.amazondex.entity.Arvore;
import br.unisc.amazondex.pojo.ArvoreDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArvoreRepository extends JpaRepository<Arvore, Integer> {

    @Query("""
            SELECT a
            FROM Arvore a
            LEFT JOIN FETCH a.biologiaReprodutiva
            LEFT JOIN FETCH a.ocorrenciaNatural
            LEFT JOIN FETCH a.fotoArvore
            LEFT JOIN FETCH a.paisagismo
            LEFT JOIN FETCH a.aproveitamento
            LEFT JOIN FETCH a.cultivo
            WHERE a.id = :arvoreId
            """)
    Optional<ArvoreDTO> findArvoreByIdWithAllRelations(Integer arvoreId);

    @Query("""
            SELECT a
            FROM Arvore a
            LEFT JOIN FETCH a.biologiaReprodutiva
            LEFT JOIN FETCH a.ocorrenciaNatural
            LEFT JOIN FETCH a.fotoArvore
            LEFT JOIN FETCH a.paisagismo
            LEFT JOIN FETCH a.aproveitamento
            LEFT JOIN FETCH a.cultivo
            """)
    List<ArvoreDTO> findAllArvoresWithAllRelations();
}
