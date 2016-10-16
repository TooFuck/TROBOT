package com.tf.tfpeople;

import org.json.*;

public class Threaf
{
	public static String  tt;
	public static String hd(String t) 
		{
			try
			{
			
				JSONObject	 jo=new JSONObject(htmls.testGetHtml("http://www.tuling123.com/openapi/api?key=0c8ef6a7d5338a676edcfd5ba4786090tf&info=" + codeto.getUTF8XMLString(t)));
				int cd =  jo.get("code");
				switch(cd){
					case 100000:
						tt=(String) jo.get("text");break;
					case 200000:
					
						tt=(String)jo.get("text")+"\n连接是:"+(String)jo.get("url");break;
					case 302000:
						JSONArray jy=jo.getJSONArray("list");
						JSONObject jo1=jy.getJSONObject(0);
						tt=(String)jo.get("text")+"\n标题:"+jo1.getString("article")+"\n连接是:"+jo1.getString("detailurl");break;
					case 308000:
						JSONArray jy1=jo.getJSONArray("list");
						JSONObject jo2=jy1.getJSONObject(1);
						tt=(String)jo.get("text")+"\n菜名:"+jo2.getString("name")+"\n材料:"+jo2.getString("info")+"\n链接是:"+jo2.getString("detailurl");break;
						
					
					
					
					
				}
				
				
				
				
				
				
				
				
				
				
				}
			catch (JSONException e)
			{}

		

			return tt;
		
		
		
	}
	
	
	
	
}
