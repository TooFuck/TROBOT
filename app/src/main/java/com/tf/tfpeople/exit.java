package com.tf.tfpeople;

import java.util.LinkedList;
import java.util.List;
import android.app.Activity;
import android.app.Application;
public class exit extends Application {
 private List activityList = new LinkedList();
 private static exit instance;
 private exit()
 {
 }
 //单例模式中获取唯一的ExitApplication实例
 public static exit getInstance()
 {
 if(null == instance)
 {
 instance = new exit();
 }
 return instance;
 }
 //添加Activity到容器中
 public void addActivity(Activity activity)
 {
 activityList.add(activity);
 }
 //遍历所有Activity并finish
 public void exit()
 {
 for(Activity activity:activityList)
 {
 activity.finish();
 }
 System.exit(0);
 }
 }
