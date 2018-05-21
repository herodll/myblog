package designpattern.bridge.ImpDao;

import designpattern.bridge.Implementor.Software;

public class AddressList extends Software{

    @Override
    public void run() {
        System.out.println("run address list");
    }
}
