package com.itel.szj;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;

/**
 * 图片转视频
 * 本页面负责提供图片目录，以及转之后的视频名字，宽度，高度。以及用来传递数据的handler
 */
public class MainActivity extends Activity {
	public static String START = "开始";
	public static String END = "结束";
	public static String PAUSE = "暂停";
	public static String RESTART = "继续";
	EditText et_path;
	Button start,pause;
	String path ;//生成视频的路径
	String videoName;//生成的视频名
	ArrayList<Images> imagePathData;//要转成的图片集合
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_to_video_main);
		path =  Environment.getExternalStorageDirectory() .getAbsolutePath() + File.separator + "my_screen";
		imagePathData = FileUtil.getImagePaths(path);
		L.i("图片数量 ="+imagePathData.size());
		videoName = "test0411.mp4";
        et_path = (EditText)findViewById(R.id.editText1);
        start = (Button)findViewById(R.id.button1);
        pause = (Button)findViewById(R.id.button2);
        start.setText(START);
        pause.setText(PAUSE);
        
        start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = ((Button)v).getText().toString();
				if(START.equals(text)){
					VideoCapture.start(MainActivity.this, handler, imagePathData, path, videoName, 1920, 1080);
					start.setText(END);
				}else
				if(END.equals(text)){
					VideoCapture.stop();
					start.setText(START);
				}				
			}
		});
        pause.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String text = ((Button)v).getText().toString();
				if(PAUSE.equals(text)){
					VideoCapture.pause();
					pause.setText(RESTART);
				}else
				if(RESTART.equals(text)){
					VideoCapture.restart();
					pause.setText(PAUSE);
				}
			}
		});
    }

	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what){
				case 0:
					L.i("生成成功");
					et_path.setText("生成成功");
					break;
				case 1:
					L.i("生成失败");
					et_path.setText("生成失败");
					break;
			}
		}
	};

}
