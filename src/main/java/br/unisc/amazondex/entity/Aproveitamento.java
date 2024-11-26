package br.unisc.amazondex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "aproveitamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Aproveitamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "arvore_id", referencedColumnName = "id")
    @OneToOne
    private Arvore arvore;

    @Column(name = "descricao")
    private String descricao;

    @OneToOne(mappedBy = "aproveitamento", cascade = CascadeType.ALL)
    private Biotecnologia biotecnologia;

    @OneToOne(mappedBy = "aproveitamento", cascade = CascadeType.ALL)
    private Alimentacao alimentacao;

    @OneToOne(mappedBy = "aproveitamento", cascade = CascadeType.ALL)
    private Bioatividade bioatividade;

}
