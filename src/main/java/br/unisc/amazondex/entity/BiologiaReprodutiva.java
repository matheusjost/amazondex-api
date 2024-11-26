package br.unisc.amazondex.entity;

import br.unisc.amazondex.enums.BiologiaReprodutivaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "biologia_reprodutiva")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class BiologiaReprodutiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "arvore_id", referencedColumnName = "id")
    @OneToOne
    private Arvore arvore;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private BiologiaReprodutivaEnum tipo;

    @Column(name = "descricao")
    private String descricao;

}
