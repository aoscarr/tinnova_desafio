package br.com.tinnova.concessionaria.controller.dto;

import br.com.tinnova.concessionaria.modelo.Veiculo;

public class DetalhesDoVeiculoDto {
    private Long id;
    private String nome;
    private String marca;
    private Integer ano;
    private String descricao;
    private boolean vendido;

    public DetalhesDoVeiculoDto (Veiculo veiculo){
        this.id = veiculo.getId();
        this.nome = veiculo.getNome();
        this.marca = veiculo.getMarca().getNome();
        this.ano = veiculo.getAno();
        this.descricao = veiculo.getDescricao();
        this.vendido = veiculo.isVendido();
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

    public String getDescricao() {
        return descricao;
    }

    public boolean isVendido() {
        return vendido;
    }
}
