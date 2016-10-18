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

public class about extends AppCompatActivity
{

	private static final long SPLASH_DELAY_MILLIS=2056;
//*
    
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		
	
		setTheme(R.style.Theme_AppCompat_NoActionBar);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		Toolbar tb=(Toolbar) findViewById(R.id.mToolbar);
		tb.setTitle("  关 于");
		
		
}

}

