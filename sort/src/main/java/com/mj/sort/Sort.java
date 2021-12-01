package com.mj.sort;

public abstract class Sort {
    protected Integer[] array;
    protected int comCount;
    protected int swapCount;
    public void sort(Integer[] array){
        if(array == null || array.length < 2)return;
        this.array = array;
        sort();
    }

    protected abstract void sort();

    /**
     * 返回值等于0代表array[i1] == array[i2]
     * 返回值大于0代表array[i1] < array[i2]
     * 返回值小于0代表array[i1] > array[i2]
     */
    protected int cmp(int i1,int i2){
        comCount++;
        return array[i1] - array[i2];
    }
    protected void swap(int i1,int i2){
        swapCount++;
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

}
