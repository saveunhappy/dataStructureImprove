package com.mj;

public class Main {
    public static void main(String[] args) {
        int[] array = {10,9,19,28,37,56,34};
        //第一层循环就是最右边一直往左边走，因为你每一次都能选出最大的，在最右边，每次做减减的操作
        for (int end = array.length - 1; end > 0; end--) {
            //从一开始，所以下面写的就是和begin - 1开始了，和前面的进行比较，就是从0开始了
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
