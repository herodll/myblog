package designpattern.decorator.ConcreteDecorator;
import designpattern.decorator.Decorator.Finery;

/**
 * Created by Administrator on 2018/5/22.
 */
public class Shoes extends Finery{

    public void show(){
        super.show();
        System.out.print(" shoes ");

    }
}
