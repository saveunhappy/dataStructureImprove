package com.mj.sort.cmp;

import com.mj.sort.Sort;

public class BubbleSort3<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //sortIndex的初始值在数组完全有序的时候有用,但是我们每次都初始化为0，就是
            //有可能后面部分有序，就看他让不让我们失望了，如果后面有序的话，那这个也能减少比较次数
            int sortIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin,begin - 1) < 0) {
                    swap(begin,begin - 1);
                    sortIndex = begin;
                }
            }
            end = sortIndex;
        }
    }
}
