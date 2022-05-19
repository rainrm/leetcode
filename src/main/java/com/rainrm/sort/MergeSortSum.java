package com.rainrm.sort;

public class MergeSortSum {
    public static void main(String[] args) {
        int[] b = {2,6,3,2,7};
        int m = process(b, 0, b.length - 1);

        for (int i = 0; i <b.length ; i++) {
            System.out.print(b[i]);
        }
        System.out.println(m);
    }


    //计算一个数组的小和
    public static int process(int[] arr,int l,int r){
        if (l == r){
            return 0;
        }

        int mid = l + ((r-l) >> 1);

        return  process(arr,l,mid) +
                process(arr,mid + 1,r) +
                merge(arr,l,mid,r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        //排序和计算小和
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        int i = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p1]>arr[p2]?(r-p2+1):0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j <help.length ; j++) {
            arr[l+j] = help[j];
        };
        return res;
    }
}
