package br.unisc.amazondex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "arvore")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Arvore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao_botanica")
    private String descricaoBotanica;

    @Column(name = "aspectos_ecologicos")
    private String aspectosEcologicos;

    @Column(name = "regeneracao_natural")
    private String regeneracaoNatural;

    @OneToMany(mappedBy = "arvore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OcorrenciaNatural> ocorrenciaNatural;

    @OneToOne(mappedBy = "arvore", cascade = CascadeType.ALL)
    private BiologiaReprodutiva biologiaReprodutiva;

    @OneToMany(mappedBy = "arvore", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FotoArvore> fotoArvore;

    @OneToOne(mappedBy = "arvore", cascade = CascadeType.ALL)
    private Paisagismo paisagismo;

    @OneToOne(mappedBy = "arvore", cascade = CascadeType.ALL)
    private Aproveitamento aproveitamento;

    @OneToOne(mappedBy = "arvore", cascade = CascadeType.ALL)
    private Cultivo cultivo;

}
