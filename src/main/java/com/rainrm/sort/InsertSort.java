package com.rainrm.sort;

public class InsertSort {
    public static void main(String[] args) {

        int[] m = {1,4,2,6,4,8,5,9,3};
        A(m);
        for (int i = 0; i <m.length ; i++) {
            System.out.print(m[i]);
        }
    }

    public static void A(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >=0 && arr[j] > arr[j+1]; j--) {
                B(arr,j,j+1);
            }
        }

    }

    public static void B(int[] arr,int i,int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }





}
