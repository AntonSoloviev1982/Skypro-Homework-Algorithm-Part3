package com.example.skyprohomeworkalgorithmpart3;

import java.util.Arrays;
import java.util.Random;

public class ArraySorted {
    public static void main(String[] args) {
        Integer[] array1 = generateRandomArray();
        Integer[] array2 = Arrays.copyOf(array1, array1.length);
        Integer[] array3 = array1.clone();

        long start1 = System.currentTimeMillis();
        sortBubble(array1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        sortSelection(array2);
        System.out.println(System.currentTimeMillis() - start2);

        long start3 = System.currentTimeMillis();
        sortInsertion(array3);
        System.out.println(System.currentTimeMillis() - start3);



    }

    public static Integer[] generateRandomArray() {
        Random random = new Random();
        Integer[] arr = new Integer[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000);
        }
        return arr;
    }

    public static void sortBubble(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = 0;
            for (int j= 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int idxMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[idxMin] > arr[j]) {
                    idxMin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idxMin];
            arr[idxMin] = temp;
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


}
