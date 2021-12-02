package com.mj.sort.cmp;

import com.mj.sort.Sort;

public class SelectionSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
//                if(array[maxIndex] < array[begin]){
                if(cmp(maxIndex,begin) <=0){
                    maxIndex = begin;
                }
            }
//            int temp = array[maxIndex];
//            //每次都放到最后
//            array[maxIndex] = array[end];
//            array[end] = temp;
            swap(maxIndex,end);
        }
    }
}
