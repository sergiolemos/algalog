package br.com.xpt.log.api.controller;

import br.com.xpt.log.api.assembler.OcorrenciaAssembler;
import br.com.xpt.log.api.dto.request.OcorrenciaRequest;
import br.com.xpt.log.api.dto.response.OcorrenciaResponse;
import br.com.xpt.log.domain.model.Entrega;
import br.com.xpt.log.domain.model.Ocorrencia;
import br.com.xpt.log.domain.service.RegistroOcorrenciaService;
import br.com.xpt.log.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaResponse registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService.registrar(entregaId,ocorrenciaRequest.getDescricao());
        return ocorrenciaAssembler.toResponse(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaResponse> listar(@PathVariable Long entregaId){
        Entrega entrega = solicitacaoEntregaService.pesquisar(entregaId);
        return ocorrenciaAssembler.toColletionModel(entrega.getOcorrencias());

    }
}
