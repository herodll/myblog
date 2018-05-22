package designpattern.decorator.Decorator;

import designpattern.decorator.ConcreteComponent.Person;

/**
 * Created by Administrator on 2018/5/22.
 */
public class Finery extends Person{
    protected Person component;

    //打扮
    public void decorate(Person component){
        this.component = component;
    }
    public void show(){
        if(component !=null){
            component.show();
        }
    }

}
