package br.unisc.amazondex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "cuidados_especiais")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class CuidadosEspeciais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "cultivo_id", referencedColumnName = "id")
    @ManyToOne
    private Cultivo cultivo;

    @Column(name = "tipo_cuidado")
    private String tipoCuidado;

    @Column(name = "descricao")
    private String descricao;

}
