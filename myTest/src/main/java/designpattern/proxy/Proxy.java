package designpattern.proxy;

/**
 * Created by Administrator on 2018/5/24.
 */
public class Proxy implements ProxyInterface {

    Pursuit gg;

    Proxy(SchoolGirls mm){
        gg = new Pursuit(mm);
    }
    @Override
    public void sendFlowers() {
        gg.sendFlowers();
    }

    @Override
    public void sendChocolate() {
        gg.sendChocolate();
    }
}
