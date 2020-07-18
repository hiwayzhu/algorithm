package com.algorithm.demo.sorts_11;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr){
        if(arr.length<=0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            boolean hassort =false;
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    hassort = true;
                }
            }
            if(!hassort) break;
        }

    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();
        int[] arr = {3,5,7,9,8,6,4,2,2,1,10};
        bs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
