package br.com.tinnova.concessionaria.controller.dto;

import br.com.tinnova.concessionaria.modelo.Veiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VeiculoDto {
    private Long id;
    private String nome;
    private String marca;
    private Integer ano;

    public VeiculoDto (Veiculo veiculo){
        this.id = veiculo.getId();
        this.nome = veiculo.getNome();
        this.marca = veiculo.getMarca().getNome();
        this.ano = veiculo.getAno();
    }
    public static List<VeiculoDto> converter (List<Veiculo> veiculos){
        return veiculos.stream().map(VeiculoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public Integer getAno() {
        return ano;
    }

}
