package com.mj;

public class Main {
    public static void main(String[] args) {
        int[] array = {10,9,19,28,37,56,34};
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if(array[begin] < array[begin - 1]){
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                }
            }
        }

        for (int j : array) {
            System.out.print(j + "_");
        }


    }
}
