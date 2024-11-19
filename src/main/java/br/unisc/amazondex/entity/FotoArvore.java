package br.unisc.amazondex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "foto_arvore")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class FotoArvore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "arvore_id", referencedColumnName = "id")
    @ManyToOne
    private Arvore arvore;

    @JoinColumn(name = "foto_id", referencedColumnName = "id")
    @ManyToOne
    private Arquivo foto;

    @Column(name = "descricao")
    private String descricao;

}
