package br.com.xpt.log.api.assembler;

import br.com.xpt.log.api.dto.response.EntregaResponse;
import br.com.xpt.log.api.dto.request.EntregaRequest;
import br.com.xpt.log.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {
    private ModelMapper modelMapper;

    public EntregaResponse toModel(Entrega entrega){
        return  modelMapper.map(entrega, EntregaResponse.class);
    }
    public List<EntregaResponse> toColletionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaRequest entregaRequestDTO){
        return modelMapper.map(entregaRequestDTO,Entrega.class);
    }
}
