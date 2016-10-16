package com.tf.tfpeople;

import java.io.*;
import java.net.*;public class codeto
{
	public static String gbk;
	public static String ud;
	
	
	
	public static String getUTF8XMLString(String xml){
		// A StringBuffer Object
		StringBuffer sb= new StringBuffer();
		sb.append(xml);
	String xmString="";
	String xmlUTF8="";
	try{
			xmString=new String(sb.toString().getBytes("UTF-8"));
		xmlUTF8=URLEncoder.encode(xmString,"UTF-8");
			//System.out.println("utf-8 编码："+xmlUTF8);
	}catch(UnsupportedEncodingException e){
			//　　// TODO Auto-generated catch block
			e.printStackTrace();}
		//　　}
		//　　// return to String Formed
	return xmlUTF8;
}
	
	
	
	
	
}
