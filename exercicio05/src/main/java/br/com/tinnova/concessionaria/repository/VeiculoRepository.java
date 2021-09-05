package br.com.tinnova.concessionaria.repository;

import br.com.tinnova.concessionaria.modelo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByMarcaNome(String nomeMarca);
}
