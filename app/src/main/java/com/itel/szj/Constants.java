package com.itel.szj;

import android.Manifest;
import android.os.Environment;

import java.io.File;

/**
 * projectName: 	    WeiBo
 * packageName:	        com.luoxiang.weibo
 * className:	        Constants
 * author:	            Luoxiang
 * time:	            2016/9/8	9:22
 * desc:	            adb shell monkey -p com.moyansz.magic3d  -v 10000
 */
public interface Constants {
    /**
     * APP文件夹路径
     */
    String FILE_FOLDER = Environment.getExternalStorageDirectory() .getAbsolutePath() + File.separator+"imgtovideo/Resources/Play";

    /**
     * 图片的文件夹
     */
    String FILE_PICTRUES_FLODER = FILE_FOLDER + File.separator + "my_screen";

    /**
     * 配置文件
     */
    String FILE_CONFIG = FILE_FOLDER + File.separator + "config.txt";

    /**
     * 生成的3D模型的存放路径
     */
    String FILE_PLY_FLODER = FILE_FOLDER + File.separator + "ply";
    /**
     * 截屏图片的位置
     */
    String FILE_SCREEN_FLODER = Environment.getExternalStorageDirectory() .getAbsolutePath() + File.separator + "imgtovideo";
    /**
     * 视频存放路径
     */
    String FILE_VIDEO_FLODER = FILE_FOLDER + File.separator + "my_screen";

    /**
     * 公司的主页
     */
    String URL_HOME = "http://www.moyansz.com";
    /**
     * 关键词
     * 带给显示的页面的路径
     */
    String EXTRA_PLY_PATH = "extra_ply_path";
    /**
     * 显示页面是否需要分享
     */
    String EXTRA_PLY_SHARE = "extra_ply_share";

    /**
     * 权限申请
     * SD卡的读取和写入
     */
    String[] PERMS_EXTERNAL_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE" ,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

    String[] PERMS_EXTERNAL_STORAGE_CAMERA = {
            Manifest.permission.CAMERA ,
            "android.permission.READ_EXTERNAL_STORAGE" ,
            Manifest.permission.WRITE_EXTERNAL_STORAGE ,
            };

}
