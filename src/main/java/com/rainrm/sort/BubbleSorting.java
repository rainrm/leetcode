package com.rainrm.sort;

public class BubbleSorting {
    public static void main(String[] args) {

        int[] b = {2,6,3,2,7,3,8,8,3,6,3,8,9,3};
        A(b);
        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]);
        }
    }




    public static void A(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }

        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j <i ; j++) {
                if (arr[j] > arr[j + 1]){
                    B(arr,j,j+1);
                }

            }

        }

    }



    public static void B(int[] arr,int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
