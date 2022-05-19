package com.rainrm.sort;

public class quickSort {
    public static void main(String[] args) {

        int[] a = {2,4,1,3,5,6,8,7};
        quickSort(a,0,a.length-1);

        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }


    public static void quickSort(int[] arr,int L, int R){
        if (L < R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while (l<more){
            if (arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if (arr[l] > arr[r]){
                swap(arr,l,--more);
            }else {
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int i, int r) {
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
    }

}
