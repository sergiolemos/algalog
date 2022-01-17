package br.com.xpt.log.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OcorrenciaResponse {

    private Long id;
    private String descricao;
    private LocalDateTime dataRegistro;
}
