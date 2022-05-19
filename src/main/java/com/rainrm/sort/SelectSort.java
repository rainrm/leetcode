package com.rainrm.sort;

public class SelectSort {
    public static void main(String[] args) {


        int[] b = {3,5,7,3,2,7,8};
        A(b);
        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]);
        }
    }




    public static void A(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }

        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
               minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            B(arr,i,minIndex);

        }
    }


    public static void B(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
