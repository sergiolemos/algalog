package br.com.xpt.log.domain.service;

import br.com.xpt.log.api.exception.NegocioException;
import br.com.xpt.log.domain.model.Entrega;
import br.com.xpt.log.domain.model.Ocorrencia;
import br.com.xpt.log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId,String descricao){
        Entrega entrega = solicitacaoEntregaService.pesquisar(entregaId);
       return entrega.adicionarOcorrencia(descricao);
    }
}
