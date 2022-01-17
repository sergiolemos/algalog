package br.com.xpt.log.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OcorrenciaRequest {

    @NotBlank
    private String descricao;
}
