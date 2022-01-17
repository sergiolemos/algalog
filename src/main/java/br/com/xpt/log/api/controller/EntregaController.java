package br.com.xpt.log.api.controller;

import br.com.xpt.log.api.assembler.EntregaAssembler;
import br.com.xpt.log.api.dto.response.EntregaResponse;
import br.com.xpt.log.api.dto.request.EntregaRequest;
import br.com.xpt.log.domain.repository.EntregaRepository;
import br.com.xpt.log.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaResponse solicitar(@Valid @RequestBody EntregaRequest entregaRequest){
        return entregaAssembler
                .toModel(solicitacaoEntregaService.solicitar(
                        entregaAssembler.toEntity(entregaRequest)
                    ));
    }

    @GetMapping
    public List<EntregaResponse> listar(){
        return entregaAssembler.toColletionModel(entregaRepository.findAll());

    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaResponse> pesquisar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{entregaId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
        solicitacaoEntregaService.finalizar(entregaId);
    }

}
