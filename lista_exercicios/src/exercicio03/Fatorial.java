package exercicio03;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fatorial {
    private static Map<Integer, BigInteger> fatoriais = new HashMap<>();

    //Calculo do fatorial utilizando o conceito de Programacao Dinamica.
    public static void main(String[] args){

        System.out.print("Digite um número para o calculo do fatorial: ");
        int fatorial = new Scanner(System.in).nextInt();

        System.out.println("Fatorial de " + fatorial + " é: " + calculoFatorial(fatorial));
    }

    private static BigInteger calculoFatorial(Integer fatorial) {
        BigInteger resultado;
        if(fatorial < 2) {
            resultado = BigInteger.valueOf(1);
            if(fatorial < 0)
                throw new IllegalArgumentException("Valor inválido. O fatorial deve ser maior ou igual a 0.");
        }
        else{
            resultado = fatoriais.get(fatorial);
            if(resultado == null){
                resultado = calculoFatorial(fatorial-1).multiply(BigInteger.valueOf(fatorial));
                fatoriais.put(fatorial, resultado);
            }
        }
       return resultado;
    }
}
