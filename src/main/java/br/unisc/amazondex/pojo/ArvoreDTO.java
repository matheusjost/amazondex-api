package br.unisc.amazondex.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ArvoreDTO {
    Integer getId();
    String getNome();
    String getDescricaoBotanica();
    String getAspectosEcologicos();
    String getRegeneracaoNatural();
    BiologiaReprodutivaDTO getBiologiaReprodutiva();
    List<OcorrenciaNaturalDTO> getOcorrenciaNatural();
    List<FotoArvoreDTO> getFotoArvore();
    CultivoDTO getCultivo();
    PaisagismoDTO getPaisagismo();
    AproveitamentoDTO getAproveitamento();
}
