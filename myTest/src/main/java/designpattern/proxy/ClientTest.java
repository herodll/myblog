package designpattern.proxy;

/**
 * Created by Administrator on 2018/5/24.
 */
public class ClientTest {

    public static void main(String[] args) {


        SchoolGirls jiaojiao = new SchoolGirls("jiaojiao");
        Proxy daiwei = new Proxy(jiaojiao);
        daiwei.sendFlowers();
        daiwei.sendChocolate();

        /*
        运行结果：
        send flowers to jiaojiao
        send chocolate to jiaojiao
         */
    }

}
