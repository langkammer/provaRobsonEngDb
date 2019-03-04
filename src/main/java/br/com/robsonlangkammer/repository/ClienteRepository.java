package br.com.robsonlangkammer.repository;

import br.com.robsonlangkammer.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
