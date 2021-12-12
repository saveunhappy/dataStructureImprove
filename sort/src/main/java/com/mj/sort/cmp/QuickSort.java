package com.mj.sort.cmp;

import com.mj.sort.Sort;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        //确定轴点位置
        int mid = pivotIndex(begin,end);
        sort(begin,mid);
        sort(mid + 1,end);
    }
    private int pivotIndex(int begin,int end){
        swap(begin,begin + (int)(Math.random() * (end - begin)));
        //备份begin位置的元素
        T pivot = array[begin];
        end--;
        while (begin < end){
            while (begin < end){
                if(cmp(pivot,array[end]) < 0){
                    end--;
                }else{
                    //右边元素 <= 轴点元素
                    //右边的覆盖掉左边的，然后左边的元素++，那就一样代码了
                    //代码走到这里，就说明要走if(cmp(pivot,array[end]) > 0)的逻辑了，所以要break
                    array[begin++] = array[end];
                    break;
                }
            }
            //当end比轴点元素大的话，就执行end--
        while (begin < end){
            if(cmp(pivot,array[begin]) > 0){
                begin++;
            }else {
                //代码走到这里，就说明要走if(cmp(pivot,array[end]) < 0)的逻辑了，所以要break
                array[end--] = array[begin];
                break;
            }
        }

        }
        array[begin] = pivot;
        //返回轴点元素的位置
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(Math.random());
    }
}
