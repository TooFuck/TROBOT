package com.tf.tfpeople;


import android.os.*;
import android.support.v7.widget.Toolbar;
//包含
import android.support.v7.widget.AppCompatButton;
//import com.gc.materialdesign.views.ButtonRectangle;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import com.gc.materialdesign.views.ButtonRectangle;
import android.view.View.*;
import android.view.*;

import android.support.v7.app.*;
import com.gc.materialdesign.widgets.*;
import android.support.v7.widget.*;
import android.util.*;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.*;
import java.util.*;
import org.json.*;
import java.io.*;
import android.net.*;
import android.widget.AdapterView.*;
import com.baidu.appx.uikit.*;




public class MainActivity extends AppCompatActivity
{int ti=0;
	/*TF机器人
	 状态： 已上线    版本：2.1.9   版本历史
	 App ID : 8363884
	 App Key : oQeEfjWxoz5DHHVQf2HsNu4vlMMMBzMF
	 Secret Key : x2EbT71lWziOEoRdaBzzdZ9hqqHtnVts
	 编辑更新 官方认证
	 0
	 昨日下载
	 20
	 总下载统计*/


	 


	String	sec="L1h6n6sdSIVBEb9GnS58QWmX";
	//"oQeEfjWxoz5DHHVQf2HsNu4vlMMMBzMF";  0c8ef6a7d5338a676edcfd5ba4786090
	String   api=	"oQeEfjWxoz5DHHVQf2HsNu4vlMMMBzMF";
	private static final int MSG_SUCCESS = 0;
	private static final int MSG_FAILURE = 1;
	public String  file="TFchat";
	public  String t,chatlt,sex,high,speed;
	public static	 ListView talkView;
	public static	com.gc.materialdesign.views.ButtonRectangle b; 
//	public android.support.v7.app.AlertDialog adg;
	public static   EditText e;public static MainActivity m;
	public static List<xiaoxi> list;
	private Thread mThread;
	String fileName = "ch";
	//SQLiteDatabase db = openOrCreateDatabase("ch.db", MODE_PRIVATE, null);
//从本地读取朗读配置
	String filename = "set";




// 加载菜单布局
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
// 菜单点击事件
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case R.id.set:
				Intent intent = new Intent();
				//设置跳转界面
				intent.setClass(MainActivity.this, set.class);
				//放入一个字符串
				//启动跳转
				MainActivity.this.startActivity(intent);
				break;
			case R.id.exit:
		exit.getInstance().exit();
			MainActivity.this.finish();
						break;
			case R.id.about:
				Intent intent1 = new Intent();
				//设置跳转界面
				intent1.setClass(MainActivity.this, about.class);
				//放入一个字符串
				//启动跳转
				MainActivity.this.startActivity(intent1);
			//	MainActivity.this.finish();
				//Toast.makeText(MainActivity.this, "你好", Toast.LENGTH_SHORT).show();
				break;
		}
		return super.onOptionsItemSelected(item);
	}





	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg)
		{//此方法在ui线程运行  
			switch (msg.what)
			{
				case MSG_SUCCESS:
                 	xiaoxi xh=(xiaoxi) msg.obj;
					list.add(xh);
					talkView.setAdapter(new xiaoxillllspq(MainActivity.this, list));
					talkView.setDivider(null);// 去掉分割线
					talkView.setSelection(list.size());
					try
					{
						chatlt =	chatlist.getJsonFromObject(list);
					}
					catch (IOException e)
					{}
					String fileName = "ch";
					SharedPreferences preferences = getSharedPreferences(fileName, MODE_PRIVATE);

					SharedPreferences.Editor editor = preferences.edit();
					editor.putString("ch", chatlt);
					editor.commit();
					break;
				case MSG_FAILURE:
					break;
			}
		}
	};







	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)

	{setTheme(R.style.Theme_AppCompat_NoActionBar);
     
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		m = this;
		
		b = (com.gc.materialdesign.views.ButtonRectangle)findViewById(R.id.sss);
	
	 Toolbar tb=(Toolbar) findViewById(R.id.mToolbar);
		tb.setTitle("TROBOT");
	
		//初始化朗读配置
		SharedPreferences preferences1 = getSharedPreferences(filename, MODE_PRIVATE);
		sex = preferences1.getString("sex", "0");
		high = preferences1.getString("high", "5");
		speed = preferences1.getString("speed", "5");
		speech.high = high;speech.sex = sex;speech.speed = speed;

		// setContentView(R.layout.main); 
/*mSnackBar=new SnackBar.Builder(this)
.withMessage("提示信息")
        .withDuration(SnackBar.LONG_SNACK)  
        .show();  
		*/
   exit.getInstance().addActivity(this);
		e = (EditText) findViewById(R.id.mainEditText1);
		talkView = (ListView) findViewById(R.id.mainListView1);
		list = new ArrayList<xiaoxi>();

	//	BDAutoUpdateSDK.uiUpdateAction(this, new MyUICheckUpdateCallback());

		String fileName1 = "ch";
		SharedPreferences pr = getSharedPreferences(fileName1, MODE_PRIVATE);
		if (pr.getString("ch", "null").equals("null"))
		{}
		else
		{
			try
			{

				JSONArray ja=new JSONArray(pr.getString("ch", "null"));
				if (ja.length() < 80)
				{
					for (int i=1;i < ja.length();i++)
					{
						String who=ja.getJSONObject(i).getString("who");
						String name=ja.getJSONObject(i).getString("name");
						cj(who, name);

					}
				}
				else
				{
					for (int i=ja.length() - 80;i < ja.length();i++)
					{
						String who=ja.getJSONObject(i).getString("who");
						String name=ja.getJSONObject(i).getString("name");
						cj(who, name);
						talkView.setSelection(list.size());



					}
				}



			}
			catch (JSONException e)
			{}


		}


		//	loadInterstitial();showInterstitial();
		//	loadInterstitial();showInterstitial();


//shared_prefs目录下要操作的文件
		String fileName = "login";
		SharedPreferences preferences = getSharedPreferences(fileName, MODE_PRIVATE);
		String str = preferences.getString("key", "null");
		String name = preferences.getString("name", "null");
		final SharedPreferences.Editor editor = preferences.edit();
		//	SharedPreferences preferences1 = getSharedPreferences(filename, MODE_PRIVATE);

		if (!str.equals("ver5"))
		{

			{
				final SharedPreferences.Editor editor1 = preferences1.edit();


				editor1.putString("sex", "0");editor1.putString("high", "5");editor1.putString("speed", "5");
				editor1.commit();
			}


			cj("notic", "  更新:\n1.全新界面设计，采用 Material Design\n1.语音支持\n3.可长按复制聊天信息.\n4.自动捕获链接.\n5.可查图片,菜谱.");
			cj("notic","\n朗读设置在菜单里呢\n");
			

		//	editor.commit();
		}//第一次判断
		else
		{

			//cj("notic", name + " 欢迎回来");	

		}

		//监测更新
		
				talkView.setOnItemLongClickListener(new OnItemLongClickListener(){
				@Override
				public boolean onItemLongClick(AdapterView<?> p1, View p2, int p3, long p4)
				{  
					TextView tv=(TextView) p2.findViewById(R.id.TextView1);
					String nr=tv.getText().toString();

					if (nr.indexOf("http") == -1)
					{
						ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
						manager.setText(nr);
					//	Toast.makeText(MainActivity.this, "已复制到剪贴板", Toast.LENGTH_SHORT).show();
						SnackBar sb=new SnackBar(MainActivity.this,"已复制到剪贴板");
						sb.setBackgroundSnackBar(Color.GREEN);
						sb.setMessageTextSize(10);
sb.show();

					}
					else
					{
						String path =nr.substring(nr.indexOf("http"), nr.length());
						Intent intent_d= new Intent();        
						intent_d.setAction("android.intent.action.VIEW");    
						Uri content_url = Uri.parse(path);   
						intent_d.setData(content_url);  
						startActivity(intent_d);
					}

					// TODO: Implement this method
					return false;
				}
			}
		)	;



		if (net.isNetworkAvailable(MainActivity.this) != true)
		{
		android.support.v7.app.AlertDialog.Builder a = new android.support.v7.app. AlertDialog.Builder(MainActivity.this);

		
		
		
		
		
		
			//主题
			a.setTitle("无网络");
			//内容
			a.setMessage("您未开启网络,点击下方退出按钮退出本应用");
			//三个不同位置的按钮
			a.setPositiveButton("知道了", null);//后面可以添加点击事件
			a.setNeutralButton("退出", new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface p1, int p2)
					{exit.getInstance().exit();
						MainActivity.this.finish();
						// TODO: Implement this method
					}
				});

			//显示
			a.create().show();
			
			
		}//判断网络
		else
		{
			
			
			
			b.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View p1)
					{ 	
					editor.putString("key","ver5");
					editor.commit();



						
							
						
							//Toast.makeText(MainActivity.this, "姓名设置成功", Toast.LENGTH_SHORT).show();		
					if (e.getText().toString() .equals(""))
						{			SnackBar sb1=new SnackBar(MainActivity.this,"没有输入文字!!!");
							sb1.setBackgroundSnackBar(Color.RED);
							sb1.setMessageTextSize(15);
							sb1.setCanceledOnTouchOutside(true);
							sb1.show();
							//Toast.makeText(MainActivity.this, "没有输入文字", Toast.LENGTH_SHORT).show();
						}
						else
						{

							if (mThread == null)
							{
								tr v=new tr();
								v.setxx(e.getText().toString());
								v.start();
								cj("me", e.getText().toString());
								e.setText("");

							}
						}
					}}
			);
		}
	}


	/*	@Override
	 protected void onResume() {
	 // TODO Auto-generated method stub
	 super.onResume();

	 // 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
	 PgyFeedbackShakeManager.setShakingThreshold(1000);

	 // 以对话框的形式弹出
	 PgyFeedbackShakeManager.register(MainActivity.this);
	 PgyCrashManager.register(this);
	 PgyUpdateManager.register(this);
	 }
	 

/*	 public void uiUpdateAction(Context context,UICheckUpdateCallback callback){
		 
		 
		 
		 
	 }
	 */
	 
	 
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(keyCode==event.KEYCODE_BACK){
			
			
			SnackBar sb=new SnackBar(MainActivity.this,"退出在菜单里呢  ！");
			sb.setBackgroundSnackBar(Color.BLUE);
			sb.setMessageTextSize(15);
			sb.setCanceledOnTouchOutside(true);
			sb.show();
			//tToast.show("退出在菜单里哦",1000,MainActivity.m);
		}
		

		return false;
	}
	public void cj(String who, String nrr)
	{
		xiaoxi x=new xiaoxi(who, nrr);
		list.add(x);

		talkView.setAdapter(new xiaoxillllspq(MainActivity.this, list));
		talkView.setDivider(null);// 去掉分割线
		talkView.setSelection(list.size());
	}

	
	//线程

	class tr extends Thread
	{

		private String xx;

		public void setxx(String xx)
		{

			this.xx = xx;

		}


		public void run()


		{   


			String xiao=Threaf.hd(xx);
            if (xiao.indexOf("http") == -1)
			{

				xiaoxi xt=new xiaoxi("m", Threaf.hd(xx));


				mHandler.obtainMessage(MSG_SUCCESS, xt).sendToTarget();//获取图片成功，向ui线程发送MSG_SUCCESS标识和bitmap对象

			}
			else
			{
				String i=xiao.substring(xiao.indexOf("http"), xiao.length());


				xiaoxi xt=new xiaoxi("m", Threaf.hd(xx));

				xiaoxi xtt=new xiaoxi("notic", "长按我访问   " + i);

				mHandler.obtainMessage(MSG_SUCCESS, xt).sendToTarget();//获取图片成功，向ui线程发送MSG_SUCCESS标识和bitmap对象

				mHandler.obtainMessage(MSG_SUCCESS, xtt).sendToTarget();//获取图片成功，向ui线程发送MSG_SUCCESS标识和bitmap对象


			}

		}


	}
	}


	




