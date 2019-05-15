package com.example.demo.util;

import java.security.MessageDigest;

public class Encript {
    private final static String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    public static String md5(String inputStr){
        return encodeByMD5(inputStr);
    }

    private static String encodeByMD5(String originString){
        if (originString!=null) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] results = md5.digest(originString.getBytes());
                return byteArrayToHexString(results);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 轮换字节数组为十六进制字符串
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b){
        StringBuilder resultSb = new StringBuilder();
        for(int i=0;i<b.length;i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    //将一个字节转化成十六进制形式的字符串
    private static String byteToHexString(byte b){
        int n = b;
        if(n<0)
            n=256+n;
        int d1 = n/16;
        int d2 = n%16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
