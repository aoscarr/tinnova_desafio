package br.com.tinnova.concessionaria.controller.form;

import br.com.tinnova.concessionaria.modelo.Veiculo;
import br.com.tinnova.concessionaria.repository.VeiculoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoVeiculoForm {
    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull
    private String descricao;

    public Veiculo atualizar(Long id, VeiculoRepository veiculoRepository){
        Veiculo veiculo = veiculoRepository.getOne(id);
        veiculo.setNome(nome);
        veiculo.setDescricao(descricao);

        return veiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
