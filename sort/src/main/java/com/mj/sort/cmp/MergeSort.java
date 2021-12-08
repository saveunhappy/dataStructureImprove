package com.mj.sort.cmp;

import com.mj.sort.Sort;

@SuppressWarnings("all")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    public void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);

    }

    private void merge(int begin, int mid, int end) {
        //li是复制出来的那一半的0位置，le是复制出来的那一半的结尾，就是整个数组的一半位置
        int li = 0, le = mid - begin;
        //ri是右半段开始的位置，re结尾，
        int ri = mid, re = end;
        //ai是一直比较两边大小，从刚开始的0到结尾的那个，但是有递归，所以就是从begin开始了
        int ai = begin;
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        //li<le就是左边还没有选完，如果左边选完了，那右边就不用动了，因为左边是有序的，右边也是有序的
        //右边本来就是有序的，那就不用动了。
        while (li < le) {
            //ri<re是右边还没有结束呢，那就右边和左边比较，右边要是小的话那就覆盖掉ai的位置，并且都往后加一
            if (ri < re && cmp(array[ri], leftArray[li]) < 0){
                array[ai++] = array[ri++];
            }else {
                //到这里就是说明左边的大，那么就左边的覆盖，如果右边弄完了，也能进到这里
                //右边弄完了，那你直接一个一个搬过去就好了。
                array[ai++] = leftArray[li++];
            }
        }
    }

}
