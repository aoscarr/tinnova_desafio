package br.com.tinnova.concessionaria.controller.form;

import br.com.tinnova.concessionaria.modelo.Marca;
import br.com.tinnova.concessionaria.modelo.Veiculo;
import br.com.tinnova.concessionaria.repository.MarcaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VeiculoForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String marca;
    @NotNull @NotEmpty
    private String descricao;
    @NotNull
    private Integer ano;

    public Veiculo converter(MarcaRepository marcaRepository){
        Marca marca = marcaRepository.findByNome(this.marca);
        return new Veiculo(nome, marca, ano, descricao);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
