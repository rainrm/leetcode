package com.rainrm.test;

public class Numbers1 {
    public static void main(String[] args) {
        String str = "9472384927";
//        char[] chars = str.toCharArray();
//        int m = chars.length;
//        int s = (int)(m/4);
//        int l = m%4;
//
//        if (s == 0){
//            if (l == 0){
//                return;
//            }else if (l == 1){
//                //只有各位一个数
//                print(chars[0]);
//            }else if (l == 2){
//                //个位和十位数
//                print(chars[1]);
//                System.out.print("十");
//                print(chars[0]);
//            }else if (l==3){
//                //个位十位百位
//                print(chars[2]);
//                System.out.print("百");
//                print(chars[1]);
//                System.out.print("十");
//
//            }
//        }

        System.out.println();



    }


    public static void print(char a){
        if (a == '0'){
            System.out.print("零");
        }else if (a == '1'){
            System.out.print("一");
        }else if (a == '2'){
            System.out.print("二");
        }else if (a == '3'){
            System.out.print("三");
        }else if (a == '4'){
            System.out.print("四");
        }else if (a == '5'){
            System.out.print("五");
        }else if (a == '6'){
            System.out.print("六");
        }else if (a == '7'){
            System.out.print("七");
        }else if (a == '8'){
            System.out.print("八");
        }else if (a == '9'){
            System.out.print("九");
        }
    }
}
