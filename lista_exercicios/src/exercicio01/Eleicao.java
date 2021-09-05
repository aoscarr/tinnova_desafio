package exercicio01;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Eleicao {
    private int totalEleitores;
    private int votosValidos;
    private int votosNulos;
    private int votosEmBranco;

    public Eleicao(int totalEleitores, int votosValidos, int votosNulos, int votosEmBranco) {

        boolean somaValoresInvalido = totalEleitores != (votosEmBranco + votosNulos + votosValidos);
        boolean totalEleitoresMenorQueAsPartes =    totalEleitores < votosValidos   ||
                                                    totalEleitores < votosNulos     ||
                                                    totalEleitores < votosEmBranco;

        if(totalEleitores == 0 || totalEleitoresMenorQueAsPartes || somaValoresInvalido)
            throw new IllegalArgumentException("Valores inválidos. o total de eleitores deve ser maior que zero, maior que os votos válidos, nulos e brancos e a soma dos brancos, nulos e válidos deve corresponder ao total.");

        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosNulos = votosNulos;
        this.votosEmBranco = votosEmBranco;
    }

    public String percentualVotosValidos(){
        return calculaPercentual(votosValidos) + "%";
    }
    public String percentualVotosEmBranco(){
        return calculaPercentual(votosEmBranco) + "%";
    }
    public String percentualVotosNulo(){
        return calculaPercentual(votosNulos) + "%";
    }
    private BigDecimal calculaPercentual(int votos){
        return BigDecimal.valueOf(((double) votos / totalEleitores) * 100).setScale(2, RoundingMode.HALF_UP);
    }


    public int getTotalEleitores() {
        return totalEleitores;
    }

    public int getVotosValidos() {
        return votosValidos;
    }

    public int getVotosNulos() {
        return votosNulos;
    }
    public int getVotosEmBranco() {
        return votosEmBranco;
    }
}
