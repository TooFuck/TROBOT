package com.tf.tfpeople;

import android.app.*;
import android.os.*;
import android.view.*;
import com.baidu.appx.*;

import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.appx.BDBannerAd;
import com.baidu.appx.BDInterstitialAd;
import com.baidu.appx.BDSplashAd;
import com.baidu.appx.BaiduAppX;
import android.widget.*;
import android.view.View.*;


public class splash extends Activity{

	private static final long SPLASH_DELAY_MILLIS=956;

		@Override

protected void onCreate(Bundle savedInstanceState) {

	setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen);
	super.onCreate(savedInstanceState);

	
	setContentView(R.layout.splash);
/*	Button n=(Button) findViewById(R.id.splashButton1);
	n.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View p1)
		{
			loadInterstitial();showInterstitial();
				
				// TODO: Implement this method
			}
		});

	}
	
private BDSplashAd splashAd = null;
private void createSplashAd() {
	if (null == splashAd) {
		splashAd = new BDSplashAd(splash.this,"oQeEfjWxoz5DHHVQf2HsNu4vlMMMBzMF","U028t6sL0laoGszO5sCDYGH5");
		

	}
}
public void loadSplashAd() {
	createSplashAd();
	splashAd.loadAd();
	
}

public void showSplashAd() {
	createSplashAd();
	if (splashAd.isLoaded()) {
		splashAd.showAd();
	}
	
}
	
	
	
	*/

		new Handler().postDelayed(new Runnable(){

					public void run(){
						Intent intent = new Intent();
						//设置跳转界面
						intent.setClass(splash.this, MainActivity.class);
						//放入一个字符串
					
						//启动跳转
						splash.this.startActivity(intent);
				splash.this.finish();


						
			


					}

			},SPLASH_DELAY_MILLIS);

		}

}
