package com.mj.sort;

import java.text.DecimalFormat;

public abstract class Sort implements Comparable<Sort>{
    protected Integer[] array;
    protected int cmpCount;
    protected int swapCount;
    protected long time;
    protected DecimalFormat fmt = new DecimalFormat("#.00");
    public void sort(Integer[] array){
        if (array == null || array.length < 2) return;
        this.array = array;
        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    @Override
    public int compareTo(Sort o) {
            int result = (int)(time - o.time);
            if (result != 0) return result;

            result = cmpCount - o.cmpCount;
            if (result != 0) return result;

            return swapCount - o.swapCount;
    }

    protected abstract void sort();

    /**
     * 返回值等于0代表array[i1] == array[i2]
     * 返回值大于0代表array[i1] < array[i2]
     * 返回值小于0代表array[i1] > array[i2]
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1].compareTo(array[i2]);
    }
    protected int cmpElement(Integer v1,Integer v2){
        cmpCount++;
        return v1.compareTo(v2);
    }
    protected void swap(int i1,int i2){
        swapCount++;
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        return "【" + getClass().getSimpleName() + "】\n"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";

    }private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }


}
