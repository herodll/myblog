package designpattern.bridge.AbsDao;

import designpattern.bridge.Abstarction.Brand;

/**
 * Created by Administrator on 2018/5/21.
 */
public class Huawei extends Brand{

    @Override
    public void run() {
        System.out.print("Huawei ");
        software.run();
    }
}
