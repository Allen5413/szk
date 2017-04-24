package com.allen.util;

import java.text.DecimalFormat;

/**
 * Created by Allen on 2016/12/19.
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        if(null == str){
            return true;
        }else{
            str = str.trim();
            if("".equals(str) || 1 > str.length()){
                return true;
            }else{
                return false;
            }
        }
    }

    /**
     * 把转义后的html标签换成转义前的
     * @param str
     * @return
     */
    public static String encodeHtml(String str){
        str = str.replace("&lt;", "<");
        str = str.replace("&nbsp;", " ");
        str = str.replace("&quot;", "\"");
        str = str.replace("&gt;", ">");
        return str;
    }

    private static final String STR_FORMAT = "00000000";

    public static String haoAddOne_2(String liuShuiHao){
        Integer intHao = Integer.parseInt(liuShuiHao);
        intHao++;
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return df.format(intHao);
    }

    public static void main(String[] args) {

        String str = "wwewe#@#dfdfdf#@#dfdfd#@#dfdfd";
        String[] s = str.split("#@#");
        System.out.println(s.length+"      sdsdsd@@@");
    }
}
