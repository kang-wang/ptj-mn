package com.ptj.util;

/**
 * @author wh
 * @create 2018-12-02 19:32
 **/
public class NameUtil {
    public static void main(String[] args) {
        System.out.println(telToName("18188971747"));
    }
    public static String telToName(String tel){
        return tel.substring(0,3)+"****"+tel.substring(7,11);
    }
}
