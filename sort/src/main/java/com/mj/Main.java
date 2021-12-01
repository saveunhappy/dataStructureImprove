package com.mj;

import com.mj.sort.BubbleSort2;
import com.mj.sort.BubbleSort3;
import com.mj.sort.HeapSort;
import com.mj.sort.SelectionSort;
import com.mj.tools.Asserts;
import com.mj.tools.Integers;
import com.mj.tools.Times;

public class Main {
    public static void main(String[] args) {
//        int[] array = {10, 9, 19, 28, 37, 56, 34};
//        Integer[] array = Integers.random(10000, 1, 100);
        //Integer[] array = Integers.ascOrder(1,10000);
//        Integer[] array = Integers.tailAscOrder(1,10000,4000);
//        Integer[] array1 = Integers.copy(array);
//        Integer[] array2 = Integers.copy(array);
//        Integers.println(array);
//        Times.test("冒泡排序1",()->{
//            bubbleSort1(array);
//        });
//        Times.test("冒泡排序2",()->{
//            bubbleSort2(array1);
//        });
//        Times.test("冒泡排序3",()->{
//            bubbleSort3(array2);
//        });

        Integer[] array1 = Integers.random(10000, 1, 20000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);
//        selectionSort(array);
        Times.test("HeapSort",()->{
            new HeapSort().sort(array2);
        });
        Times.test("SelectionSort",()->{
            new SelectionSort().sort(array1);
        });

        Times.test("BubbleSort3",()->{
            new BubbleSort3().sort(array3);
        });
    }
    static void selectionSort(Integer[] array){
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if(array[maxIndex] < array[begin]){
                    maxIndex = begin;
                }
            }
            int temp = array[maxIndex];
            //每次都放到最后
            array[maxIndex] = array[end];
            array[end] = temp;
        }
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
        for (int end = array.length - 1; end > 0; end--) {
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
    static void bubbleSort3(Integer[] array){
        for (int end = array.length - 1; end > 0; end--) {
            //sortIndex的初始值在数组完全有序的时候有用
            int sortIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int temp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = temp;
                    sortIndex = begin;
                }
            }
            end = sortIndex;
        }
    }
}
