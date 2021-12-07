package com.mj.sort.cmp;

import com.mj.tools.Asserts;

public class BinarySearch {
    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(v < array[mid]){
                end = mid;
            }else if (v > array[mid]){
                begin = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 这个是查插入的位置，不是找元素了，大于等于的话就是到mid+1  到   end
     * 查询v在有序数组中的插入位置
     * @param array
     * @param v
     * @return
     */
    public static int search(int[] array,int v){
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(v < array[mid]){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        //最终begin和end是一样的，所以返回哪个都行
        return begin;
    }
    public static void main(String[] args) {
        int[] array = {2,4,8,8,8,12,14};
        Asserts.test(BinarySearch.search(array,5) == 2);
        Asserts.test(BinarySearch.search(array,1) == 0);
        Asserts.test(BinarySearch.search(array,15) == 7);
        Asserts.test(BinarySearch.search(array,8) == 5);
    }
}
