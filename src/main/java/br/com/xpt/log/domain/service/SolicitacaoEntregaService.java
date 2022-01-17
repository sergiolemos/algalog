package br.com.xpt.log.domain.service;

import br.com.xpt.log.api.exception.EntidadeNaoEncontradaException;
import br.com.xpt.log.api.exception.NegocioException;
import br.com.xpt.log.domain.model.Cliente;
import br.com.xpt.log.domain.model.Entrega;
import br.com.xpt.log.domain.model.StatusEntrega;
import br.com.xpt.log.domain.repository.ClienteRepository;
import br.com.xpt.log.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.pesquisar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }

    public Entrega pesquisar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(()->new EntidadeNaoEncontradaException("Entrega não localizada"));
    }

    @Transactional
    public void finalizar(Long entregaId){
        Entrega entrega = pesquisar(entregaId);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}
