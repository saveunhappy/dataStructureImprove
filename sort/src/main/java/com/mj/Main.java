package com.mj;

import com.mj.sort.*;
import com.mj.tools.Asserts;
import com.mj.tools.Integers;
import com.mj.tools.Times;

import java.util.Arrays;

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
        testSort(array1,new HeapSort(),new SelectionSort(),new BubbleSort3(),new BubbleSort1(),new BubbleSort2());
    }

    static void testSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            sort.sort(Integers.copy(array));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);

        }
    }

}
