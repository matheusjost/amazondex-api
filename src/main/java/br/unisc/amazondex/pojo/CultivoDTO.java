package br.unisc.amazondex.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface CultivoDTO extends ComboDTO {
    List<CuidadosEspeciaisDTO> getCuidadosEspeciais();
}
