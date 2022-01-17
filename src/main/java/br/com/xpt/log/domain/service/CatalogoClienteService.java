package br.com.xpt.log.domain.service;

import br.com.xpt.log.api.exception.NegocioException;
import br.com.xpt.log.domain.model.Cliente;
import br.com.xpt.log.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    public Cliente pesquisar(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(()->new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail");
        }
        return  clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
