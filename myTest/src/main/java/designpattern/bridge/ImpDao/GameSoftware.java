package designpattern.bridge.ImpDao;

import designpattern.bridge.Implementor.Software;

/**
 * Created by Administrator on 2018/5/21.
 */
public class GameSoftware extends Software {

    @Override
    public void run() {
        System.out.println("run gameSoftware");
    }
}
