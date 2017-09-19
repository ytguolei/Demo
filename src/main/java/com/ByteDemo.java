package com;

import java.io.UnsupportedEncodingException;

public class ByteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "中";  
        char x ='中';  
        byte[] bytes=null;  
        byte[] bytes1=null;  
        try {  
            bytes = str.getBytes("utf-8");  
            bytes1 = charToByte(x);  
        } catch (UnsupportedEncodingException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        System.out.println("bytes 大小："+bytes.length);  
        System.out.println("bytes1大小："+bytes1.length); 
	}
	
	public static byte[] charToByte(char c) {   
        byte[] b = new byte[2];   
        b[0] = (byte) ((c & 0xFF00) >> 8);   
        b[1] = (byte) (c & 0xFF);   
        return b;   
    } 

}
