package gjj.rongclouddemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import io.rong.imkit.RongIM;

/**
 * 作者：gjj on 2015/12/9 17:40
 * 邮箱：Gujj512@163.com
 * {"code":200,"userId":"gujingjing","token":"wIJAPbu9M399JrYC1q0MnwxXEtrTv+TLPQOopLi4DZ7YVsYKw4lJKjudJAzXQzT04b7ZSP9KnbkjX3VNa8bfQICXUmLdtNXg"}
 */
public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * OnCreate 会被多个进程重入，这段保护代码，确保只有您需要使用 RongIM 的进程和 Push 进程执行了 init。
         * io.rong.push 为融云 push 进程名称，不可修改。
         */
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {

            /**
             * IMKit SDK调用第一步 初始化
             */
            RongIM.init(this);
        }
    }
    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return 进程号
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
