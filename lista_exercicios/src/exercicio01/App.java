package exercicio01;

public class App {

    public static void main(String[] args) {
        Eleicao eleicao = new Eleicao(1000, 700, 199, 101);

        System.out.println(eleicao.percentualVotosValidos());
        System.out.println(eleicao.percentualVotosEmBranco());
        System.out.println(eleicao.percentualVotosNulo());

    }
}
