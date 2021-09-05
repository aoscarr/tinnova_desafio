package exercicio02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenacao {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 3, 2, 4, 7, 1, 0, 6);
        System.out.println("Vetor nao ordenado.");
        array.forEach(System.out::println);

        array = bubbleSort(array);
        System.out.println("\nVetor ordenado.");
        array.forEach(System.out::println);
    }

    public static List<Integer> bubbleSort(List<Integer> array){
        // complexidade de O(N^2). É um dos piores algoritmos de ordenacao. A titulo de curiosidade, nos links abaixo ha a implementacao do Quicksort em C e Assembly feitos por mim :).
        //https://github.com/aoscarr/academic-projects/blob/master/mata49-progSoftBasico/quick.c
        //https://github.com/aoscarr/academic-projects/blob/master/mata49-progSoftBasico/ArturOscar_PSB_quicksort/quicksort.asm
        return bubbleSortRecursive(array, array.size());
    }
    private static List<Integer> bubbleSortRecursive(List<Integer> array, int n){
        if(n < 1)
            return array;
        for(int i = 0; i < n-1; i++)
            if(array.get(i) > array.get(i+1))
                Collections.swap(array, i, i+1);

        return bubbleSortRecursive(array, n-1);
    }
}
