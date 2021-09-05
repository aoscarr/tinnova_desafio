package br.com.tinnova.concessionaria.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Marca marca;
    private Integer ano;
    private String descricao;
    private boolean vendido = false;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private LocalDateTime dataModificacao = LocalDateTime.now();

    public Veiculo(String nome, Marca marca, Integer ano, String descricao) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
    }

    public Veiculo(){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Marca getMarca() {
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }
}
