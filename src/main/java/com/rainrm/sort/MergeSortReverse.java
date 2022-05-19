package com.rainrm.sort;

public class MergeSortReverse {
    private static int res=0;
    public static void main(String[] args) {
        int[] b = {2,6,3,2};
        process(b, 0, b.length - 1);
        System.out.println(res);
        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]);
        }


    }

    public static void process(int[] arr,int L,int R){
        if (L == R){
            return ;
        }
        int mid = L + ((R - L) >>1);
        process(arr,L,mid);
        process(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R-L +1];

        int i = 0;
        int p1 = L;
        int p2 = M +1;

        while (p1 <= M && p2 <= R){
            res = arr[p1] > arr[p2] ?(res+(M-p1)+1):res;
            help[i++] = arr[p1]<= arr[p2]?arr[p1++]:arr[p2++];
        };
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }


        //把help数组拷贝到arr数组中
        for (int j = 0; j <help.length ; j++) {
            arr[L + j] = help[j];
        }


    }


}
