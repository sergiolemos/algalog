package br.com.xpt.log.api.assembler;

import br.com.xpt.log.api.dto.response.OcorrenciaResponse;
import br.com.xpt.log.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaResponse toResponse(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia,OcorrenciaResponse.class);
    }

    public List<OcorrenciaResponse> toColletionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
