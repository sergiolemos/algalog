package br.com.xpt.log.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class EntregaRequest {

    @Valid
    @NotNull
    private ClienteRequest cliente;

    @Valid
    @NotNull
    private DestinatarioRequest destinatario;

    private BigDecimal taxa;
}
