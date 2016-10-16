package com.tf.tfpeople;

import java.io.*;
import org.codehaus.jackson.map.*;
import org.codehaus.jackson.*;

public class chatlist
{
	public static String getJsonFromObject(Object object) throws JsonProcessingException, IOException{
		String json = null;
		ObjectMapper  mapper  = new ObjectMapper();
		json = mapper.writeValueAsString(object);
        return json;
	}
	
	
	
	
}
