package designpattern.bridge.Abstarction;
import designpattern.bridge.Implementor.Software;

/**
 * Created by Administrator on 2018/5/21.
 */
public abstract class Brand {

    //设置为子类访问权限protected，子类可以直接访问，调用对应的run()
    protected Software software;

    public Software getSoftware() {
        return software;
    }
    //设置手机软件
    public void setSoftware(Software software) {
        this.software = software;
    }
    //运行
    public abstract void run();
}
