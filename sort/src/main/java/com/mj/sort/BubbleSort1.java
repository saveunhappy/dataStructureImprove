package com.mj.sort;

public class BubbleSort1 extends Sort{
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //从一开始，所以下面写的就是和begin - 1开始了，和前面的进行比较，就是从0开始了
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin,begin - 1) < 0) {
                   swap(begin,begin - 1);
                }
            }
        }
    }
}
