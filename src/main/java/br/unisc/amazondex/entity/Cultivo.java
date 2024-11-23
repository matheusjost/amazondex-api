package br.unisc.amazondex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "cultivo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Cultivo implements Serializable {

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

    @OneToMany(mappedBy = "cultivo", cascade = CascadeType.ALL)
    private Set<CuidadosEspeciais> cuidadosEspeciais;

}
