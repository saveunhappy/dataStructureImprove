package com.mj.sort.cmp;

import com.mj.sort.Sort;

public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int current = begin;
            E v = array[current];
            while (current > 0 && cmp(v, array[current - 1]) < 0) {
                array[current] = array[current - 1];
                current--;
            }
            array[current] = v;
        }
    }
}
