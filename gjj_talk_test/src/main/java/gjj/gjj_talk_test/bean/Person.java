package gjj.gjj_talk_test.bean;

import cn.bmob.v3.BmobObject;

/**
 * 作者：gjj on 2015/12/9 15:59
 * 邮箱：Gujj512@163.com
 */
public class Person extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
