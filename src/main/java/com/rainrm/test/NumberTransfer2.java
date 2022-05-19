package com.rainrm.test;

public class NumberTransfer2 {
    public static final String[] chnNumStr = new String[]{"零","一","二","三","四","五","六","七","八","九"};
    public static final String[] chnSmUintStr = new String[]{"","十","百","千"};
    public static final String[] chnBgUintStr = new String[]{"","万","亿","万亿"};

    public static void main(String[] args) {
        long[] nums = new long[]{304L, 4006L, 4000L, 10003L, 10030L, 21010011L, 101101101L,9101101101L,22111L};

        for (int i = 0; i <nums.length ; i++) {
            String convert = convert(nums[i]);
            System.out.println(convert);
        }
    }


    public static String convert(long num){
        String unitStr;
        String chnStr = "";
        int unitPoit = 0;
        boolean needZero = false;
        if (num == 0){
            return "零";
        }
        while (num > 0){
            //unitStr = "";
            if (needZero){
                chnStr = chnNumStr[0] + chnStr;
            }
            //获取第一部分一万以内的数;
            long section = num%10000;
            //根据section是否为0判断需要添加节权
            unitStr = (section != 0 ? chnBgUintStr[unitPoit]:chnBgUintStr[0]);
            chnStr = unitStr + chnStr;
            chnStr = convertSm(section, chnStr);

            if (section <1000 && section > 0){
                needZero=true;
            }
            num = num/10000;
            unitPoit++;
        }
        return chnStr;
    }



    public static String convertSm(long section,String chnStr){
        //转换一个1万以内的数
        //添加单位的变量
        String unitStr;
        int unitPoit = 0;
        boolean zero = true;

        while (section > 0){
            //对10取余，判断个位数
            long m = section%10;
            if (m == 0 && !zero){
                //判断不重复添加零;只有在数据的右侧是非零的情况下才会执行一下的代码
                zero = true;
                //只添加零，不添加小单位
                chnStr = chnNumStr[0] + chnStr;
            }else if (m > 0){
                zero = false;
                //加上单位
                unitStr = chnSmUintStr[unitPoit];
                chnStr = unitStr + chnStr;
                //加上m位置对应的中文
                chnStr = chnNumStr[(int) m] + chnStr;
            }
            section = section/10;
            unitPoit++;
        }
        return chnStr;
    }

}
