package com.example.zym.mynotificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button send_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_notification = (Button) findViewById(R.id.send_notification);
        send_notification.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notification:
                //通知详情页面
                Intent intent = new Intent(this,NotificationActivity.class);
                //得到PendingIntent实例
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                //通知的管理类
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                //点击通知后，手机状态栏上通知消失
                //manager.cancel(1);
                Notification notification = new NotificationCompat.Builder(this)
                        //设置通知的标题
                        .setContentTitle("腾讯新闻")
                        //设置通知的正文内容
                        .setContentText("一男子因表白失败跳楼自杀")

                        //通知正文内容过长，显示全部内容
                        /*.setStyle(new NotificationCompat.BigTextStyle().bigText("gfffffffffffffffffffffffffffffgggggggggggg" +
                                "jkggggggggggggggggggggggggggggggggggggggggggggggggggggg" +
                                "hjffffffffffffffffffffffffffffffff"))*/

                        //显示一张大图
                        //.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.timg_4)))

                        //设置通知的小图标
                        .setSmallIcon(R.mipmap.ic_launcher)
                        //设置通知的大图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.timg_4))
                        //实现点击通知跳转到通知详情页面
                        .setContentIntent(pi)
                        //点击通知后，手机状态栏上通知消失
                        .setAutoCancel(true)
                        //播放一段音频提示用户有通知
                        .setSound(Uri.fromFile(new File("")))

                        //通过手机振动提示用户
                        //下标为1代表振动1秒，下标为2表示手机静止1秒，下标为3表示再振动1秒
                        //.setVibrate(new long[] {0,1000,1000,1000})


                        //通过呼吸灯提示用户
                        //第一个参数表示呼吸灯的颜色，第二个参数表示呼吸灯亮起的时长，第三个参数表示呼吸灯暗去的时长
                        //.setLights(Color.GREEN,1000,1000)

                        //设置通知的重要级别
                        //有五个常量值：DEFAULT,MIN,LOW,HIGH,MAX
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                //调用notify（）方法将通知显示在手机状态栏上
                manager.notify(1,notification);
                break;
        }
    }
}
