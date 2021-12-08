package com.mj;

import com.mj.sort.*;
import com.mj.sort.cmp.*;
import com.mj.tools.Asserts;
import com.mj.tools.Integers;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer[] array1 = Integers.random(10000, 1, 20000);
        Integer[] array2 = Integers.copy(array1);
        Integer[] array3 = Integers.copy(array1);
        testSort(array1,
                new HeapSort(),
                new SelectionSort(),
                new BubbleSort3(),
                new InsertionSort1(),
                new InsertionSort2(),
                new MergeSort(),
                new InsertionSort3());

//        int[] array = {2,4,6,8,10};
//        Asserts.test(BinarySearch.indexOf(array,4) == 1);
    }

    static void testSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);

        }
    }

}
