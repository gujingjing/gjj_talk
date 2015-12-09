package gjj.gjj_talk_test;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * 作者：gjj on 2015/12/9 15:52
 * 邮箱：Gujj512@163.com
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化bomb
        // 初始化 Bmob SDK
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, "efcf42f8e92573ebf5117aec46c78783");
    }
}
