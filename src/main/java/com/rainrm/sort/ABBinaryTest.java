package com.rainrm.sort;


public class ABBinaryTest {
    public static void main(String[] args) {

        int[] m = {1,1,2,2,4,4,6,6,7,7,3,9};
        A(m);

    }
    //条件
    //一个数组中，只有两个数出现了奇数次，其他的数都是出现了偶数次，求出这两个数分别是
    //思路，如果只有两个数出现了奇数次，那直接把数组中的数和0遍历^之后剩下的就是a^b;然后因为a和b一定不相等，所以a^b一定是不为0的
    //所以a^b一定是二进制上一定是有一个位置上是1的，所以可以获取到这个最右侧是1的数，根据这个位置可以把a和b分开，然后数组里的数据也是根据最右侧这个位置上是1
    //或者是0按偶数分布的，所以，
    public static void A(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        int a = 0;
        for (int i = 0; i <arr.length ; i++) {
            a = a ^arr[i];
        }

        //a最终的结果应该是两个不相等的奇数进行异或

        int rightOne = a&(~a +1);
        int b = 0;
        for (int cur: arr){
            if ((cur & rightOne) == rightOne){  //这个位置老师讲的还可以等于1，但是我试了1不行
                b = b ^ cur;
            }

        }

        System.out.println(b +  "" + (b^a));


    }

}
