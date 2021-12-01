package com.mj;

import com.mj.tools.Integers;
import com.mj.tools.Times;

public class Main {
    public static void main(String[] args) {
//        int[] array = {10, 9, 19, 28, 37, 56, 34};
//        Integer[] array = Integers.random(10000, 1, 100);
        Integer[] array = Integers.ascOrder(1,10000);
        Integer[] copy = Integers.copy(array);
        Integers.println(array);
        Times.test("冒泡排序1",()->{
            bubbleSort1(array);
        });
        Times.test("冒泡排序2",()->{
            bubbleSort2(copy);
        });

    }
    static void bubbleSort1(Integer[] array){
        //第一层循环就是最右边一直往左边走，因为你每一次都能选出最大的，在最右边，每次做减减的操作
        /*
         *优化一下，如果本来就是完全有序的呢？能不能提前终止？可以的，因为第一轮，如果没有发生交换，就说明右边就是
         * 最大的，中间没有发生交换，哪怕有一个不是有序的，也得进去循环，所以可以加一个flag，但是flag不能加在
         * 外层，而是要加在里层，因为有可能就是你交换了一两次之后变成完全有序了，所以我们每次假定它是有序的
         * 就看他能不能让我们失望了
         */
        //boolean sorted = true   x    不能卸载这里
        for (int end = array.length - 1; end > 0; end--) {
            //从一开始，所以下面写的就是和begin - 1开始了，和前面的进行比较，就是从0开始了
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                }
            }
        }
    }
    static void bubbleSort2(Integer[] array){
        //第一层循环就是最右边一直往左边走，因为你每一次都能选出最大的，在最右边，每次做减减的操作
        /*
         *优化一下，如果本来就是完全有序的呢？能不能提前终止？可以的，因为第一轮，如果没有发生交换，就说明右边就是
         * 最大的，中间没有发生交换，哪怕有一个不是有序的，也得进去循环，所以可以加一个flag，但是flag不能加在
         * 外层，而是要加在里层，因为有可能就是你交换了一两次之后变成完全有序了，所以我们每次假定它是有序的
         * 就看他能不能让我们失望了
         */
        //boolean sorted = true   x    不能卸载这里
        for (int end = array.length - 1; end > 0; end--) {
            //从一开始，所以下面写的就是和begin - 1开始了，和前面的进行比较，就是从0开始了
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}
