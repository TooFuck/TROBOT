package com.tf.tfpeople;

import android.content.*;
import android.os.*;
import android.view.*;
import com.tf.tools.*;
import com.gc.materialdesign.views.*;
import android.view.View.*;
import android.support.v7.app.*;
import android.widget.EditText;
import android.support.v7.widget.*;
import com.gc.materialdesign.widgets.*;
import android.graphics.*;
public class set extends AppCompatActivity
{
	public Button setman,setwomen;
	public EditText edhigh,edspeed;
	public String high,speed,sex,sextemp;
	public static set s;
	private static final long SPLASH_DELAY_MILLIS=2056;

	@Override

	protected void onCreate(Bundle savedInstanceState)
	{
		setTheme(R.style.Theme_AppCompat_NoActionBar);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set);
		s=this;
		Toolbar tb=(Toolbar) findViewById(R.id.mToolbar);
		tb.setTitle("  设 置");
		AlertDialog.Builder a=new AlertDialog.Builder(set.this);
		a.setTitle("设置说明");
		
		a.setMessage("软件可设置性别,语速,语调\n语速，语调范围在  0~9  数值越大语速，语调越高\n不修改则不填\n点击返回自动保存");
		a.setPositiveButton("知道了",null);
		a.create().show();
	//	tDialog td=new tDialog();
		//td.show("设置说明","软件可设置性别,语速,语调\n语速，语调范围在  0~9  数值越大语速，语调越高\n不修改则不填\n点击返回自动保存",set.s);
		
        setman=(Button) findViewById(R.id.setman);
		setwomen=(Button) findViewById(R.id.setwomen);
		edspeed= (EditText) findViewById(R.id.setspeed);
		edhigh=(EditText) findViewById(R.id.sethigh);
		
		String fileName = "set";
		SharedPreferences preferences = getSharedPreferences(fileName, MODE_PRIVATE);
		 speed= preferences.getString("speed", "5");
		sex= preferences.getString("sex", "0");
		high= preferences.getString("high", "5");
		
		
		SharedPreferences.Editor editor = preferences.edit();
		String now ="当前为: ";
		edspeed.setHint(now+speed);
		edhigh.setHint(now+high);
		  
		
		
		setman.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					sex="1";
					//tToast.show("你选择了男声",2000,set.s);
					SnackBar s= new SnackBar(set.this,"你选择了男声"); 
					s.setBackgroundSnackBar(Color.BLUE);
					s.setMessageTextSize(15);
					s.setCanceledOnTouchOutside(true);
					s.show();
					
					// TODO: Implement this method
				}
			});


		setwomen.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					sex="0";
					//tToast.show("你选择了女声",2000,set.s); 
					
 SnackBar s= new SnackBar(set.this,"你选择了女声"); 
					s.setCanceledOnTouchOutside(true);
s.setBackgroundSnackBar(Color.BLUE);
s.setMessageTextSize(15);
s.show();

					// TODO: Implement this method
				}
			});

	}




	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == event.KEYCODE_BACK)
		{	
    String h=   edhigh.getText().toString();
	String s=edspeed.getText().toString();	
		if(h.length()>1){	

			SnackBar s1= new SnackBar(set.this,"请输入正确值 ！"); 
			s1.setBackgroundSnackBar(Color.RED);
			s1.setMessageTextSize(15);
			s1.setCanceledOnTouchOutside(true);
			s1.show();
			//tToast.show("请输入正确值",2000,set.s);	
		}
		
		else if(s.length()>1){
			SnackBar s1= new SnackBar(set.this,"请输入正确值 ！"); 
			s1.setBackgroundSnackBar(Color.RED);
			s1.setMessageTextSize(15);
			s1.setCanceledOnTouchOutside(true);
			s1.show();
			//tToast.show("请输入正确值",2000,set.s);	
		}
			else{
			if(s.length()==1){speed=s;}
			if(h.length()==1){high=h;}
			
			
			
			AlertDialog.Builder a=new AlertDialog.Builder(set.this);
			a.setTitle("是否保存  ?");
				a.setPositiveButton("取消", new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface p1, int p2)
						{	Intent intent = new Intent();
							//设置跳转界面
							intent.setClass(set.this, MainActivity.class);
							//放入一个字符串

							//启动跳转
							set.this.startActivity(intent);
							set.this.finish();
							
							// TODO: Implement this method
						}
					});
				a.setNeutralButton("保存", new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface p1, int p2)
						{	String fileName = "set";
							SharedPreferences preferences = getSharedPreferences(fileName, MODE_PRIVATE);
							SharedPreferences.Editor editor = preferences.edit();


							editor.putString("sex",sex);
							editor.putString("speed",speed);
							editor.putString("high",high);
							editor.commit();
							/*SnackBar s1= new SnackBar(set.this,"已保存  。"); 
							s1.setBackgroundSnackBar(Color.GREEN);
							s1.setMessageTextSize(15);
							s1.show();*/
							//tToast.show("已保存",2000,set.s);

							Intent intent = new Intent();
							//设置跳转界面
							intent.setClass(set.this, MainActivity.class);
							//放入一个字符串

							//启动跳转
							set.this.startActivity(intent);
							set.this.finish();

							
							// TODO: Implement this method
						}
					});
			a.create().show();
			

			
			
			
		}
		
		


		}
		
		return false;
	}
		
		
		
		}
