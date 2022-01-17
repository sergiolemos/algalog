package br.com.xpt.log.domain.repository;

import br.com.xpt.log.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long> {
}
