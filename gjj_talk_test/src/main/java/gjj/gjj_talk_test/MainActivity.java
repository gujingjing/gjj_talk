package gjj.gjj_talk_test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import gjj.gjj_talk_test.bean.Person;
import gjj.gjj_talk_test.util.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        addDate();
//        serachDate();
//        changeDate();
        deleteDate();
    }
    public void deleteDate(){
        Person p2 = new Person();
        p2.setObjectId("f36c5e3a36");
        p2.delete(this, new DeleteListener() {
            @Override
            public void onSuccess() {
                ToastUtils.setToastLong(MainActivity.this, "删除成功");
            }

            @Override
            public void onFailure(int code, String msg) {
                ToastUtils.setToastLong(MainActivity.this, "删除失败：" + msg);
            }
        });
    }
    public void changeDate(){
        //更新Person表里面id为6b6c11c537的数据，address内容更新为“北京朝阳”
        final Person p2 = new Person();
        p2.setAddress("北京朝阳");
        p2.update(this, "f36c5e3a36", new UpdateListener() {
            @Override
            public void onSuccess() {
                ToastUtils.setToastLong(MainActivity.this, "更新成功：" + p2.getUpdatedAt());
            }
            @Override
            public void onFailure(int code, String msg) {
                ToastUtils.setToastLong(MainActivity.this, "更新失败：" + msg);
            }
        });
    }
    public void serachDate(){
        //查找Person表里面id为6b6c11c537的数据
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject(this, "f36c5e3a36", new GetListener<Person>() {
            @Override
            public void onSuccess(Person object) {
                ToastUtils.setToastLong(MainActivity.this, "查询成功"+object.getName());
            }

            @Override
            public void onFailure(int code, String msg) {
                ToastUtils.setToastLong(MainActivity.this, "查询失败：" + msg);
            }
        });
    }
    public void addDate(){
        final Person person = new Person();
        person.setName("lucky");
        person.setAddress("北京海淀");
        person.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                ToastUtils.setToastLong(MainActivity.this, "添加数据成功，返回objectId为：" + person.getObjectId());
            }

            @Override
            public void onFailure(int code, String msg) {
                ToastUtils.setToastLong(MainActivity.this, "创建数据失败：" + msg);
            }
        });
    }
}
