package br.com.tinnova.concessionaria.controller;

import br.com.tinnova.concessionaria.controller.dto.DetalhesDoVeiculoDto;
import br.com.tinnova.concessionaria.controller.dto.VeiculoDto;
import br.com.tinnova.concessionaria.controller.form.AtualizacaoVeiculoForm;
import br.com.tinnova.concessionaria.controller.form.VeiculoForm;
import br.com.tinnova.concessionaria.modelo.Veiculo;
import br.com.tinnova.concessionaria.repository.MarcaRepository;
import br.com.tinnova.concessionaria.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<VeiculoDto> lista (String marcaVeiculo){
        if(marcaVeiculo == null){
            List<Veiculo> veiculos = veiculoRepository.findAll();
            return VeiculoDto.converter(veiculos);
        }
        return VeiculoDto.converter(veiculoRepository.findByMarcaNome(marcaVeiculo));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoVeiculoDto> detalhar (@PathVariable Long id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if(veiculo.isPresent())
            return ResponseEntity.ok(new DetalhesDoVeiculoDto(veiculo.get()));

        return ResponseEntity.notFound().build();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriBuilder){

        Veiculo veiculo = form.converter(marcaRepository);
        veiculoRepository.save(veiculo);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VeiculoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoVeiculoForm form){
        Optional<Veiculo> optional = veiculoRepository.findById(id);
        if(optional.isPresent()){
            Veiculo veiculo = form.atualizar(id, veiculoRepository);
            return ResponseEntity.ok(new VeiculoDto(veiculo));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id){
        Optional<Veiculo> optional = veiculoRepository.findById(id);
        if(optional.isPresent()){
            veiculoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
