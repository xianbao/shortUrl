package com.example.demo.util;

public class WatermelonUtils {

    public static void main(String[] args) {
        String[] result = ShortText("www.baidu.com/中国", "test");
    }
    /**生成短网址长度5-64位.*/
    public static String[] ShortText(String string, String key) {
        //自定义生成MD5加密字符串前的混合KEY
        String[] chars = new String[]{          //要使用生成URL的字符
                "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p",
                "q", "r", "s", "t", "u", "v", "w", "x",
                "y", "z", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", "A", "B", "C", "D",
                "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"
        };

        String hex = Encript.md5(key + string);
        int hexLen = hex.length();
        int subHexLen = hexLen / 8;
        String[] ShortStr = new String[4];


        for (int i = 0; i < subHexLen; i++) {
            StringBuilder outChars = new StringBuilder();
            int j = i + 1;
            String subHex = hex.substring(i * 8, j * 8);
            long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);

            for (int k = 0; k < 6; k++) {
                int index = (int) (Long.valueOf("0000003D", 16) & idx);
                outChars.append(chars[index]);
                idx = idx >> 5;
            }
            ShortStr[i] = outChars.toString();
        }
        return ShortStr;
    }
}
