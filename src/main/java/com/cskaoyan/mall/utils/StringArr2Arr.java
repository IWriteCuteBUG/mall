package com.cskaoyan.mall.utils;

public class StringArr2Arr {

    public static String[] StringArr2Arr(String s) {
        s = s.replace("[", "");
        s = s.replace("]", "");
        s = s.replace("\"","");
        int count = 0;
        int index = 0;
        int substringIndex = 0;
        while ((index = s.indexOf(",", index)) != -1) {
            index = index + ",".length();
            count++;
        }
        count++;
        String[] returnString = new String[count];
        for (int i = 0; i < count; i++) {
            int i1 = s.indexOf(",");
            if (i1 != -1) {
                String substring = s.substring(0, i1);
                s = s.replace(substring + ",", "");
                System.out.println(substring);
                returnString[i] = substring;
            }
            if(i1 == -1){
                returnString[i] = s;
            }
        }

        return returnString;
    }


}
