package br.com.tinnova.concessionaria.repository;

import br.com.tinnova.concessionaria.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Marca findByNome(String nome);
}
