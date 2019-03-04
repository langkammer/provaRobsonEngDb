package br.com.robsonlangkammer.repository;

import br.com.robsonlangkammer.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor,Long> {

}
