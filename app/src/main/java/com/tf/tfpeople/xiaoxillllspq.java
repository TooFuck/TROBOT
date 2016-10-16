package com.tf.tfpeople;
import android.widget.*;
import android.view.*;
import android.database.*;
import android.content.*;
import java.util.*;
import android.widget.ExpandableListView.*;
import android.speech.tts.*;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;
import com.tf.tools.*;
import android.net.*;
public class xiaoxillllspq extends BaseAdapter
{
	public boolean isshow1=false;
	public boolean isshow2=false;

public TextToSpeech tts;
	private Context context;

	private List<xiaoxi> list;

	private LayoutInflater inflater;

	public xiaoxillllspq(Context context,List<xiaoxi> list){
		this.context = context;
        this.list= list;
   
        inflater = LayoutInflater.from(context);
    }
		
	
	
	
	
	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return list.size();
	}

	@Override
	public Object getItem(int p1)
	{
		// TODO: Implement this method
		return p1;
	}

	@Override
	public long getItemId(int p1)
	{
		// TODO: Implement this method
		return p1;
	}

	@Override
	public View getView(int p1, View p2, ViewGroup p3)
	{
		// TODO: Implement this method
		xiaoxi entity = list.get(p1);
        View view = null;
        //判断消息的类型，根据类型判断需要加载左边还是右边的item
final speech sc=new speech(context);
		if(entity.getwho().equals("me")){
		view = inflater.inflate(R.layout.me,null);
		}
	else	if(entity.getwho().equals("notic")){
			view = inflater.inflate(R.layout.notic,null);
			TextView t=(TextView) view.findViewById(R.id.TextView1);
			t.setText(entity.getname());


			
		}
		else{
			view = inflater.inflate(R.layout.he,null);
			final TextView t=(TextView) view.findViewById(R.id.TextView1);
			
			Button read=(Button) view.findViewById(R.id.read);
			read.setOnClickListener(new OnClickListener(){

					@Override
					public void onClick(View p1)
					{
                    sc.speak(t.getText().toString());
						
					
						// TODO: Implement this method
					}
				});
		}
		TextView t=(TextView) view.findViewById(R.id.TextView1);
		t.setText("\n"+entity.getname()+"\n");
		
		
		
		return view;
	}

	
	
	
	
	
}
