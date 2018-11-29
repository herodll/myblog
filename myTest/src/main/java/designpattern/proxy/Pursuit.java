package designpattern.proxy;

/**
 * Created by Administrator on 2018/5/24.
 */
//追求者类
public class Pursuit implements ProxyInterface{

    SchoolGirls mm;

    Pursuit(){}
    Pursuit(SchoolGirls mm){
        this.mm = mm;
    }

    @Override
    public void sendFlowers() {
        System.out.println("send flowers to "+this.mm.getName());
    }

    @Override
    public void sendChocolate() {
        System.out.println("send chocolate to "+this.mm.getName());
    }
}
