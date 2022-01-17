package br.com.xpt.log.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteRequest {

    @NotNull
    private Long id;
}
