package com.mj.sort.cmp;

import com.mj.sort.Sort;

public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            T v  = array[begin];
            int insertIndex = search(begin);
            for (int i = begin ; i > insertIndex; i--) {
                array[i] = array[i - 1];
            }
            array[insertIndex] = v;
        }
    }

    /**
     * 利用二分搜索找到index位置元素的待插入位置
     * 已经排好序的数组的区间范围是[0,index)
     * @param index
     * @return
     */
    private int search(int index){
        int begin = 0;
        int end = index;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(cmp(array[index],array[mid]) < 0){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
