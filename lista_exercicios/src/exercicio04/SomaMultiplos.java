package exercicio04;

import java.util.Scanner;

public class SomaMultiplos {

    // Enunciado confuso.
    public static void main(String[] args) {
        System.out.print("Digite o número: ");
        int x = new Scanner(System.in).nextInt();
        System.out.println("Resultado: " + somarMultiplosTresECinco(x));
    }

    private static long somarMultiplosTresECinco(int x) {
        long resultado = 0;
        for ( int i = 1; i <= x; i++ )
            if (i % 5 == 0 || i % 3 == 0)
                resultado += i;

        return  resultado;
    }
}
