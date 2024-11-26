package br.unisc.amazondex.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface FotoArvoreDTO {
    Integer getId();
    FileDTO getFoto();
    String getDescricao();
}
