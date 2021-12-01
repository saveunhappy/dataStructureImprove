package com.mj.sort;

public class BubbleSort3 extends Sort{
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //sortIndex的初始值在数组完全有序的时候有用
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
