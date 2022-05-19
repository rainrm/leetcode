package com.rainrm.sort;

public class RLMax {
    public static void main(String[] args) {

        int[] a = {3,2,5,6,7,4};
        int max = getMax(a);
        System.out.println(max);
//        for (int e: a) {
//            System.out.println(e);
//        }

    }


    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    };


    //在[R..L]范围上求最大值
    public static int process(int[] arr,int L,int R){
        if (L==R){
            return arr[L];
        }
        int mid = L + ((R-L)>> 1);
        int leftMax = process(arr,L ,mid);
        int rightMax = process(arr,mid + 1,R);
        return Math.max(leftMax,rightMax);
    }

}
