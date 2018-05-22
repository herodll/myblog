package designpattern.decorator.ConcreteDecorator;

import designpattern.decorator.Decorator.Finery;

/**
 * Created by Administrator on 2018/5/22.
 */
public class Trousers extends Finery{
    public void show(){
        super.show();
        System.out.print(" Trousers ");
    }
}
