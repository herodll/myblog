package designpattern.bridge;

import designpattern.bridge.AbsDao.Huawei;
import designpattern.bridge.AbsDao.Zhongxing;
import designpattern.bridge.Abstarction.Brand;
import designpattern.bridge.ImpDao.AddressList;
import designpattern.bridge.ImpDao.GameSoftware;
import designpattern.bridge.Implementor.Software;

/**
 * Created by Administrator on 2018/5/21.
 */
public class ClientTest {
    public static void main(String[] args) {

        Software software1 = new AddressList();

        Brand phone1 = new Huawei();
        phone1.setSoftware(software1);
        phone1.run();
        Brand phone2 = new Zhongxing();
        phone2.setSoftware(software1);
        phone2.run();

        Software software2 = new GameSoftware();
        phone1.setSoftware(software2);
        phone1.run();
        phone2.setSoftware(software2);
        phone2.run();

        /*
        运行结果：
        Huawei run address list
        Zhongxing run address list
        Huawei run gameSoftware
        Zhongxing run gameSoftware
         */

    }
}
